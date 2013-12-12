
public class EuropeanPut extends Put{

	public EuropeanPut(String stockTicker, double stockPrice,
			double strikePrice, double volatility, double riskFreeRate,
			double time) {
		super(stockTicker, stockPrice, strikePrice, volatility, riskFreeRate, time);
		// TODO Auto-generated constructor stub
	}

	public EuropeanPut() {
		// TODO Auto-generated constructor stub
	}

	public final static String[] validAlgos = { "B-S formula", "Binomial tree",
		"Numerical integration", "Simulation" };
}
