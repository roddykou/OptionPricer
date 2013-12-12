import java.util.ArrayList;
import java.util.Random;


public class Simulation implements Algorithm{

	@Override
	public double eval(Option option) {
		// TODO Auto-generated method stub
		double stockPrice = option.getStockPrice();
		double strikePrice = option.getStrikePrice();
		double riskFreeRate = option.getRiskFreeRate();
		double volatility = option.getVolatility();
		double time = option.getTime();
		
		ArrayList<Double> brownian = new ArrayList<Double>();
		ArrayList<Double> value = new ArrayList<Double>();
		double st;
		
		if (option instanceof Call) {
			for (int i = 0; i < 1000; i++) {
				brownian = brownianMotion(time);
				st = stockPrice * Math.exp((riskFreeRate - 0.5 * volatility * volatility) * time + volatility * brownian.get(brownian.size() - 1));
				value.add((st > strikePrice) ? st - strikePrice : 0);
			}
		} else {
			brownian = brownianMotion(time);
			st = stockPrice * Math.exp((riskFreeRate - 0.5 * volatility * volatility) * time + volatility * brownian.get(brownian.size() - 1));
			value.add((st < strikePrice) ? strikePrice - st : 0);
		}
		return Math.exp(-riskFreeRate * time) * mean(value);
	}
	
	private ArrayList<Double> brownianMotion(double time) {
		ArrayList<Double> val = new ArrayList<Double>();
		double d = Math.sqrt(0.001);
		int n = (int) (time / 0.001);
		
		val.add((double) 0);
		for (int i = 0; i < n; i++) {
			val.add(val.get(i) + random.nextGaussian() * d);
		}
		
		return val;
	}
	
	private double mean(ArrayList<Double> list) {
		double sum = 0.0;
		int length = list.size();
		for (int i = 0; i < length; i++)
			sum += list.get(i);
		return sum / length;
	}
	
	private Random random = new Random();

}
