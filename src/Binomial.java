
public class Binomial implements Algorithm{

	@Override
	public double eval(Option option) {
		// TODO Auto-generated method stub
		boolean isCall = false;
		boolean isEuro = false;
		
		if (option instanceof Call)
			isCall = true;
		if (option instanceof EuropeanCall || option instanceof EuropeanPut)
			isEuro = true;
		
		double stockPrice = option.getStockPrice();
		double strikePrice = option.getStrikePrice();
		double riskFreeRate = option.getRiskFreeRate();
		double volatility = option.getVolatility();
		double time = option.getTime();
		
		int step = 5;
		double[] value = new double[step + 1];
		double price;
		double delta = time / step;
		double up = Math.exp(volatility * Math.sqrt(delta));
		double down = 1 / up;
		double probUp = (Math.exp(riskFreeRate * delta) - down) / (up - down);
		
		for (int i = 0; i <= step; i++) {
			price = stockPrice * Math.pow(up, step - i * 2);
			if (isCall)
				value[i] = price - strikePrice;
			else
				value[i] = strikePrice - price;
			
			if (value[i] < 0)
				value[i] = 0;
		}
		
		if (isEuro) {
			while (step-- > 0) {
				for (int i = 0; i <= step; i++)
					value[i] = Math.exp(-riskFreeRate*delta)*(value[i]*probUp+value[i+1]*(1-probUp));
			}
			return value[0];
		} else {
			while(step-- > 0){
				for(int i = 0; i <= step; i++){
					price = stockPrice * Math.pow(up, step - i * 2);
					value[i] = Math.exp(-riskFreeRate * delta) * (value[i] * probUp + value[i+1] * (1 - probUp));
					if(isCall)
						price -= strikePrice;
					else
						price = strikePrice - price;
					if(price > value[i])
						value[i] = price;
				}
			}
			return value[0];
		}
		
	}

}
