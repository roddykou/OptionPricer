import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

// jreechart Java Libaray is used to generate graphs
// some code are reference from jreechart open source demo (http://stackoverflow.com/questions/16714738/xy-plotting-with-java)

public class VolatilitySmile extends JFrame {

	private static final long serialVersionUID = -5587627424958966103L;
	static double Pi = 3.14159265358979;

	public VolatilitySmile(final String title, Option option) {

		super(title);

		// double stockPrice = option.getStockPrice();
		// double strikePrice = option.getStrikePrice();
		// double riskFreeRate = option.getRiskFreeRate();
		// double time = option.getTime();
		// boolean isCall = false;
		// if (option instanceof Call)
		// isCall = true;
		//
		// double[] strikePrices = new double[9];
		// double interval = strikePrice / 10;
		// strikePrices[0] = strikePrice - interval * 5;
		// for (int i = 1; i < 9; i++)
		// strikePrices[i] = strikePrices[i - 1] + interval;
		//
		// final XYSeries xyPairs = new XYSeries("Data From File");
		// for (int i = 0; i < 9; i++) {
		// option.setStrikePrice(strikePrices[i]);
		// double implied = ImpliedVol(stockPrice, isCall, new
		// Simulation().eval(option) , strikePrices[i], time, riskFreeRate);
		// xyPairs.add(strikePrices[i], implied);
		// System.out.println("" + strikePrices[i] + " " + implied);
		// }

		final XYSeries xyPairs = new XYSeries("Data From File");
		File file = new File("graphData.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.split(" ");
				double s = Double.parseDouble(tokens[0]);
				double o = Double.parseDouble(tokens[1]);

				//
				double implied = ImpliedVol(2.2, true, o, s, 0.5, 0.06);
				xyPairs.add(s, implied);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}

		final XYSeriesCollection dataFromFile = new XYSeriesCollection(xyPairs);
		final JFreeChart chart = ChartFactory.createXYLineChart(
				"Volatility Smile Graph", "Strike Price", "Implied Volatility",
				dataFromFile, PlotOrientation.VERTICAL, true, true, false);

		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	// source:
	// http://quantcorner.wordpress.com/2012/09/18/mplied-volatility-of-options-wit-vba-excel/
	// the ImpliedVol method, pdf, and cdf methods are translated from VBA to
	// Java according the the above web site
	public static double ImpliedVol(double price, boolean isCall, double last,
			double strike, double time, double rate) {
		double X0 = 0;
		double vol;
		double d1;
		double d2;
		double vega;
		double tol;

		tol = 0.0001;
		vol = 0.2;

		while (Math.abs(price - X0) > tol) {

			d1 = (Math.log(last / strike) + (rate + vol * vol / 2) * time)
					/ (vol * Math.sqrt(time));
			d2 = d1 - vol * Math.sqrt(time);

			vega = last * Math.sqrt(time) * pdf(d1);

			if (isCall)
				X0 = last * cdf(d1) - strike * Math.exp(-rate * time) * cdf(d2);
			else
				X0 = strike * Math.exp(-rate * time) * cdf(-d2) - last
						* cdf(-d1);

			vol = vol - (X0 - price) / vega;

		}

		return vol;

	}

	public static double pdf(double x) {

		return (1 / Math.sqrt(2 * Pi)) * Math.exp(-0.5 * x * x);
	}

	public static double cdf(double x) {
		double b1;
		double b2;
		double b3;
		double b4;
		double b5;
		double p;
		double v;
		double c2;
		double a;
		double t;
		double b;
		double cdfValue;

		b1 = 0.31938153;
		b2 = -0.356563782;
		b3 = 1.781477937;
		b4 = -1.821255978;
		b5 = 1.330274429;
		p = 0.2316419;
		c2 = 0.3989423;

		a = Math.abs(x);
		t = 1 / (1 + a * p);
		b = c2 * Math.exp((-x) * (x / 2));
		v = ((((b5 * t + b4) * t + b3) * t + b2) * t + b1) * t;
		if (x > 0)
			cdfValue = 1 - b * v;
		else
			cdfValue = 1 - (1 - b * v);
		return cdfValue;

	}

}