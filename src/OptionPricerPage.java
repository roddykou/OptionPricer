import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OptionPricerPage {
	public void display() {
		JFrame jframe = new JFrame("Option Pricer");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));

		JPanel panePara = new JPanel();
		panePara.setBorder(BorderFactory.createTitledBorder("Parameters"));
		
        JPanel paneParaLabels = new JPanel(new GridLayout(0,1,1,1));
        JPanel paneParaTexts = new JPanel(new GridLayout(0,1,1,1));
        
        JTextField txtStockTicker = new JTextField(10);
        paneParaTexts.add(txtStockTicker);
        JTextField txtStockPrice = new JTextField(10);
        paneParaTexts.add(txtStockPrice);
        JTextField txtStrikePrice = new JTextField(10);
        paneParaTexts.add(txtStrikePrice);
        JTextField txtVolability = new JTextField(10);
        paneParaTexts.add(txtVolability);
        JTextField txtRiskFreeRate = new JTextField(10);
        paneParaTexts.add(txtRiskFreeRate);
        JTextField txtTerms = new JTextField(10);
        paneParaTexts.add(txtTerms);
        JComboBox dropdownDesk = new JComboBox();
        paneParaTexts.add(dropdownDesk);
        JRadioButton buttonCall = new JRadioButton("Call");
        JRadioButton buttonPut = new JRadioButton("Put");
        JPanel paneRadioButtons = new JPanel();
        paneRadioButtons.add(buttonCall, BorderLayout.WEST);
        paneRadioButtons.add(buttonPut, BorderLayout.EAST);
        ButtonGroup buttonGroup = new ButtonGroup();
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
        
//        JPanel paneRight = new JPanel();
        Box boxRight = Box.createVerticalBox();
        
        JPanel paneAlgorithm = new JPanel();
        paneAlgorithm.setBorder(BorderFactory.createTitledBorder("Algorithm"));
        
        String[] algorithms = {"B-S formula", "Binomial tree", "Numerical integration", "Simulation"};
        JList listAlgorithms = new JList(algorithms);
        paneAlgorithm.add(listAlgorithms);
        
        JPanel paneButtons = new JPanel();
        paneButtons.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JButton buttonCalculate = new JButton("Calculate");
        JButton buttonNewAlgorithm = new JButton("Add New Algorithm");
        JButton buttonNewOptions = new JButton("Add New Options");
        paneButtons.add(buttonCalculate);
        paneButtons.add(buttonNewAlgorithm);
        paneButtons.add(buttonNewOptions);
        
        JPanel paneResults = new JPanel();
        JPanel paneResult = new JPanel();
        paneResult.setBorder(BorderFactory.createTitledBorder("Result"));
        JTextField textResult = new JTextField();
        textResult.setPreferredSize(new Dimension(150,200));
        paneResult.add(textResult);
        
        JPanel paneVolatilitySmile = new JPanel();
        paneVolatilitySmile.setBorder(BorderFactory.createTitledBorder("Volatility Smile"));
        
        paneResults.add(paneResult, BorderLayout.WEST);
        paneResults.add(paneVolatilitySmile, BorderLayout.EAST);
		
        boxRight.add(paneAlgorithm);
        boxRight.add(paneButtons);
        boxRight.add(paneResults);

		contentPane.add(panePara, BorderLayout.WEST);
		contentPane.add(boxRight, BorderLayout.EAST);
        jframe.setContentPane(contentPane);
		jframe.pack();
		jframe.setVisible(true);
	}
}