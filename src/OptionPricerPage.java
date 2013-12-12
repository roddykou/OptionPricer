import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OptionPricerPage {

	private JFrame jframe = new JFrame("Option Pricer");
	private JTextField txtStockTicker = new JTextField(10);
	private JTextField txtStockPrice = new JTextField(10);
	private JTextField txtStrikePrice = new JTextField(10);
	private JTextField txtVolatility = new JTextField(10);
	private JTextField txtRiskFreeRate = new JTextField(10);
	private JTextField txtTerms = new JTextField(10);
	private String[] desks = { "America", "Europe", "Asia" };
	private JComboBox dropdownDesk = new JComboBox(desks);
	private JRadioButton buttonCall = new JRadioButton("Call");
	private JRadioButton buttonPut = new JRadioButton("Put");
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textResult = new JTextArea();
	private String[] algorithms = { "B-S formula", "Binomial tree",
			"Numerical integration", "Simulation" };
	private JList listAlgorithms = new JList(algorithms);

	public OptionPricerPage() {
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));

		JPanel panePara = new JPanel();
		panePara.setBorder(BorderFactory.createTitledBorder("Parameters"));

		JPanel paneParaLabels = new JPanel(new GridLayout(0, 1, 1, 1));
		JPanel paneParaTexts = new JPanel(new GridLayout(0, 1, 1, 1));

		paneParaTexts.add(txtStockTicker);
		paneParaTexts.add(txtStockPrice);
		paneParaTexts.add(txtStrikePrice);
		paneParaTexts.add(txtVolatility);
		paneParaTexts.add(txtRiskFreeRate);
		paneParaTexts.add(txtTerms);
		paneParaTexts.add(dropdownDesk);
		JPanel paneRadioButtons = new JPanel();
		paneRadioButtons.add(buttonCall, BorderLayout.WEST);
		paneRadioButtons.add(buttonPut, BorderLayout.EAST);
		buttonGroup.add(buttonCall);
		buttonGroup.add(buttonPut);
		paneParaTexts.add(paneRadioButtons);

		JLabel[] paraLabels = new JLabel[8];
		paraLabels[0] = new JLabel("Stock Ticker");
		paraLabels[1] = new JLabel("Stock Price");
		paraLabels[2] = new JLabel("Strike Price");
		paraLabels[3] = new JLabel("Volability");
		paraLabels[4] = new JLabel("Risk Free Rate");
		paraLabels[5] = new JLabel("Terms (year)");
		paraLabels[6] = new JLabel("Desk");
		paraLabels[7] = new JLabel("Option");
		for (int i = 0; i < 8; i++) {
			paraLabels[i].setBorder(new EmptyBorder(10, 10, 10, 10));
			paneParaLabels.add(paraLabels[i]);
		}

		panePara.add(paneParaLabels, BorderLayout.WEST);
		panePara.add(paneParaTexts, BorderLayout.EAST);

		// JPanel paneRight = new JPanel();
		Box boxRight = Box.createVerticalBox();

		JPanel paneAlgorithm = new JPanel();
		paneAlgorithm.setBorder(BorderFactory.createTitledBorder("Algorithm"));

		paneAlgorithm.add(listAlgorithms);

		JPanel paneButtons = new JPanel();
		paneButtons.setBorder(new EmptyBorder(10, 10, 10, 10));

		JButton buttonCalculate = new JButton("Calculate");
		buttonCalculate.addActionListener(new calculateAction());
		JButton buttonNewAlgorithm = new JButton("Add New Algorithm");
		buttonNewAlgorithm.addActionListener(new newAlgorithmAction());
		JButton buttonNewOptions = new JButton("Add New Options");
		buttonNewOptions.addActionListener(new newOptionAction());
		paneButtons.add(buttonCalculate);
		paneButtons.add(buttonNewAlgorithm);
		paneButtons.add(buttonNewOptions);

		JPanel paneResults = new JPanel();
		JPanel paneResult = new JPanel();
		paneResult.setBorder(BorderFactory.createTitledBorder("Result"));
		textResult.setPreferredSize(new Dimension(300, 200));
		textResult.setLineWrap(true);
		textResult.setWrapStyleWord(true);
		paneResult.add(textResult);

		JPanel paneVolatilitySmile = new JPanel();
		paneVolatilitySmile.setBorder(BorderFactory
				.createTitledBorder("Volatility Smile"));

		paneResults.add(paneResult, BorderLayout.WEST);
		paneResults.add(paneVolatilitySmile, BorderLayout.EAST);

		boxRight.add(paneAlgorithm);
		boxRight.add(paneButtons);
		boxRight.add(paneResults);

		contentPane.add(panePara, BorderLayout.WEST);
		contentPane.add(boxRight, BorderLayout.EAST);
		jframe.setContentPane(contentPane);
		jframe.pack();
	}

	public void display() {
		jframe.setVisible(true);

	}

	public void hide() {
		jframe.setVisible(false);
	}

	private class newAlgorithmAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Main.newAlgorithmPage.display();
		}
	}

	private class newOptionAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Main.newOptionPage.display();
		}
	}

	private class calculateAction implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			Option option = null;

			// build up the hard-coded select index
			int selected = dropdownDesk.getSelectedIndex();
			if (buttonCall.isSelected())
				selected += 0;
			else if (buttonPut.isSelected())
				selected += 3;

			switch (selected) {
			case 0:
				option = new AmericanCall();
				break;
			case 1:
				option = new EuropeanCall();
				break;
			case 2:
				option = new AsiaCall();
				break;
			case 3:
				option = new AmericanPut();
				break;
			case 4:
				option = new EuropeanPut();
				break;
			case 5:
				option = new AsiaPut();
				break;
			default:
				break;
			}

			option.setParas(txtStockTicker.getText(),
					Double.parseDouble(txtStockPrice.getText()),
					Double.parseDouble(txtStrikePrice.getText()),
					Double.parseDouble(txtVolatility.getText()),
					Double.parseDouble(txtRiskFreeRate.getText()),
					Double.parseDouble(txtTerms.getText()));

			Object[] selectedAlgorithm = listAlgorithms.getSelectedValues();
			int numAlgorithms = selectedAlgorithm.length;
			String results = "";

			for (int i = 0; i < numAlgorithms; i++) {
				if (selectedAlgorithm[i].toString().equals("B-S formula"))
					results += "B-S formula: " + new BlackScholes().eval(option) + "\n";
				else if (selectedAlgorithm[i].toString().equals("Binomial tree"))
					results += "Binomial tree: " + new Binomial().eval(option) + "\n";
				else if (selectedAlgorithm[i].toString().equals("Numerical integration"))
					results += "Numerical integration: " + 0.0 + "\n";
				else if (selectedAlgorithm[i].toString().equals("Simulation"))
					results += "Simulation: " + new Simulation().eval(option) + "\n";
			}

			 textResult.setText(results);
		}

	}
}
