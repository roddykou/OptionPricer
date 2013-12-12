import javax.swing.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				loginPage.display();
			}
		});

	}
	
	public static LoginPage loginPage = new LoginPage();
	public static OptionPricerPage optionPricerPage = new OptionPricerPage();
	public static NewAlgorithmPage newAlgorithmPage = new NewAlgorithmPage();
	public static NewOptionPage newOptionPage = new NewOptionPage();
}
