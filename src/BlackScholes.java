
public class BlackScholes implements Algorithm{

	@Override
	public double eval(Option option) {
		// TODO Auto-generated method stub
		double stockPrice = option.getStockPrice();
		double strikePrice = option.getStrikePrice();
		double riskFreeRate = option.getRiskFreeRate();
		double volatility = option.getVolatility();
		double time = option.getTime();
		
        double d1 = (Math.log(stockPrice/strikePrice) + (riskFreeRate + volatility * volatility/2) * time) / (volatility * Math.sqrt(time));
		double d2 = d1 - volatility * Math.sqrt(time);
		
		if (option instanceof Call)
			return stockPrice * Gaussian.Phi(d1) - strikePrice * Math.exp(-riskFreeRate * time) * Gaussian.Phi(d2);
		else
			return strikePrice * Math.exp(-riskFreeRate * time) * Gaussian.Phi(-d2) - stockPrice * Gaussian.Phi(-d1);
	}

}
