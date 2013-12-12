public class AsiaCall extends Call {

	public AsiaCall(double stockPrice, double strikePrice, double volatility,
			double riskFreeRate, double time) {
		super(stockPrice, strikePrice, volatility, riskFreeRate, time);
		// TODO Auto-generated constructor stub
	}

	public AsiaCall() {
		// TODO Auto-generated constructor stub
	}

	public final static String[] validAlgos = { "Simulation" };

}
