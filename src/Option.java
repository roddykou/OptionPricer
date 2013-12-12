import java.util.List;

public class Option {
	
	public Option() {
		
	}

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
	
	public void setParas(String stockTicker, double stockPrice, double strikePrice,
			double volatility, double riskFreeRate, double time) {
		this.stockTicker = stockTicker;
		this.stockPrice = stockPrice;
		this.strikePrice = strikePrice;
		// this.currency = currency;
		this.volatility = volatility;
		this.riskFreeRate = riskFreeRate;
		this.time = time;
	}

	public List<Algorithm> getAllowedAlgorithm(){
		return null;
	}

	public String toString() {
		String ret = "" + this.stockTicker + "\t" + this.stockPrice + "\t"
				+ this.strikePrice + "\t" + this.currency + "\t"
				+ this.volatility + "\t" + this.riskFreeRate + "\t" + this.time;
		return ret;
	}

	public String getStockTicker() {
		return stockTicker;
	}

	public void setStockTicker(String stockTicker) {
		this.stockTicker = stockTicker;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getVolatility() {
		return volatility;
	}

	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}

	public double getRiskFreeRate() {
		return riskFreeRate;
	}

	public void setRiskFreeRate(double riskFreeRate) {
		this.riskFreeRate = riskFreeRate;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	private String stockTicker;
	private double stockPrice;
	private double strikePrice;
	private String currency = "";
	private double volatility;
	private double riskFreeRate;
	private double time;
	
}
