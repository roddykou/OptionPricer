public class Option {

	public Option(String stockTicker, double stockPrice, double strikePrice,
			double volatility, double riskFreeRate, double time) {
		this.stockTicker = stockTicker;
		this.stockPrice = stockPrice;
		this.strikePrice = strikePrice;
		// this.currency = currency;
		this.volatility = volatility;
		this.riskFreeRate = riskFreeRate;
		this.time = time;
	}

	private String stockTicker;
	private double stockPrice;
	private double strikePrice;
	private String currency = "";
	private double volatility;
	private double riskFreeRate;
	private double time;

	public String toString() {
		String ret = "" + this.stockTicker + "\t" + this.stockPrice + "\t"
				+ this.strikePrice + "\t" + this.currency + "\t"
				+ this.volatility + "\t" + this.riskFreeRate + "\t" + this.time;
		return ret;
	}
}
