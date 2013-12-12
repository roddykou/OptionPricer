public class AsiaPut extends Put {

	public AsiaPut(double stockPrice, double strikePrice, double volatility,
			double riskFreeRate, double time) {
		super(stockPrice, strikePrice, volatility, riskFreeRate, time);
		// TODO Auto-generated constructor stub
	}

	public AsiaPut() {
		// TODO Auto-generated constructor stub
	}

	public final static String[] validAlgos = { "Simulation" };
}
