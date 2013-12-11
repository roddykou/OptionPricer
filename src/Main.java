import javax.swing.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
//				LoginPage p = new LoginPage();
//				p.display();

//				NewAlgorithmPage p = new NewAlgorithmPage();
//				p.display();
				
				NewOptionPage p = new NewOptionPage();
				p.display();
			}
		});

	}
}
