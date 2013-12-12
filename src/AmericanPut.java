public class AmericanPut extends Put {

	public AmericanPut(String stockTicker, double stockPrice,
			double strikePrice, double volatility, double riskFreeRate,
			double time) {
		super(stockTicker, stockPrice, strikePrice, volatility, riskFreeRate,
				time);
		// TODO Auto-generated constructor stub
	}

	public AmericanPut() {
		// TODO Auto-generated constructor stub
	}

	public final static String[] validAlgos = { "Binomial tree",
			"Numerical integration", "Simulation" };
}
