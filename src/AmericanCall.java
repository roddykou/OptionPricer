public class AmericanCall extends Call {

	public AmericanCall(String stockTicker, double stockPrice,
			double strikePrice, double volatility, double riskFreeRate,
			double time) {
		super(stockTicker, stockPrice, strikePrice, volatility, riskFreeRate,
				time);
		// TODO Auto-generated constructor stub
	}

	public AmericanCall() {
		// TODO Auto-generated constructor stub
	}

	public final static String[] validAlgos = { "B-S formula", "Binomial tree",
			"Numerical integration", "Simulation" };

}
