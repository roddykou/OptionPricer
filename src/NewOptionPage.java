import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NewOptionPage {
	public void display() {
		JFrame jframe = new JFrame("Create a New Option");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panOuter = new JPanel(new BorderLayout());
		JPanel panInputs = new JPanel(new BorderLayout());
		
		JPanel panOption = new JPanel(new BorderLayout());
		panOption.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));		
		JPanel panAlgorithm = new JPanel(new BorderLayout());
		panAlgorithm.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panFilename = new JPanel(new BorderLayout());
		panFilename.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panBottom = new JPanel(new BorderLayout());
		panBottom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		panInputs.add(panOption, BorderLayout.NORTH);
		panInputs.add(panAlgorithm, BorderLayout.CENTER);
		panInputs.add(panFilename, BorderLayout.SOUTH);
		panOuter.add(panInputs, BorderLayout.NORTH);
		panOuter.add(panBottom, BorderLayout.SOUTH);
		
		JLabel labelOption = new JLabel("Option Name: ");
		JTextField txtOption = new JTextField(10);
		panOption.add(labelOption, BorderLayout.WEST);
		panOption.add(txtOption, BorderLayout.EAST);
		
		JLabel labelAlgorithm = new JLabel("Algorithm Name: ");
		JTextField txtAlgorithm = new JTextField(10);
		panAlgorithm.add(labelAlgorithm, BorderLayout.WEST);
		panAlgorithm.add(txtAlgorithm, BorderLayout.EAST);
		
		JLabel labelFilename = new JLabel("File Name: ");
		JButton buttonBrowse = new JButton("Browse....");
		panFilename.add(labelFilename, BorderLayout.WEST);
		panFilename.add(buttonBrowse, BorderLayout.EAST);
		
		JButton buttonUpload = new JButton("Upload and Return");
		JButton buttonCancel = new JButton("Cancel");
		panBottom.add(buttonUpload, BorderLayout.WEST);
		panBottom.add(buttonCancel, BorderLayout.EAST);
		
		jframe.setContentPane(panOuter);
		jframe.setSize(600, 200);
		jframe.pack();
		jframe.setVisible(true);
	}
}
