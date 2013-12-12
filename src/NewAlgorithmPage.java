import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NewAlgorithmPage {
	
	private JFrame jframe = new JFrame("Create a New Algorithm");
	
	public NewAlgorithmPage() {
		
		JPanel panOuter = new JPanel(new BorderLayout());
		
		JPanel panAlgorithm = new JPanel(new BorderLayout());
		panAlgorithm.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panFilename = new JPanel(new BorderLayout());
		panFilename.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panBottom = new JPanel(new BorderLayout());
		panBottom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		panOuter.add(panAlgorithm, BorderLayout.NORTH);
		panOuter.add(panFilename, BorderLayout.CENTER);
		panOuter.add(panBottom, BorderLayout.SOUTH);
		
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
		buttonCancel.addActionListener(new cancelAction());
		panBottom.add(buttonUpload, BorderLayout.WEST);
		panBottom.add(buttonCancel, BorderLayout.EAST);
		
		jframe.setContentPane(panOuter);
		jframe.setSize(600, 200);
		jframe.pack();

	}

	public void display() {
		jframe.setVisible(true);
	}
	
	public void hide() {
		jframe.setVisible(false);
	}
	
	private class cancelAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Main.newAlgorithmPage.hide();
		}
	}
}
