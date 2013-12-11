import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginPage {
	public void display() {
		JFrame jframe = new JFrame("Option Pricer Login");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panOuter = new JPanel(new BorderLayout());
		
		JPanel panTop = new JPanel(new BorderLayout());
		panTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panLeft = new JPanel(new BorderLayout());
		panLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panRight = new JPanel(new BorderLayout());
		panRight.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panBottom = new JPanel(); // default is FlowLayout
		panBottom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel panInput = new JPanel(new BorderLayout());
		panInput.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		panInput.add(panLeft, BorderLayout.WEST);
		panInput.add(panRight, BorderLayout.EAST);
		panInput.add(panBottom, BorderLayout.SOUTH);
		
		panOuter.add(panInput, BorderLayout.SOUTH);
		panOuter.add(panTop, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Welcome to Option Pricer");
		label.setFont(new Font("Helvetica", Font.PLAIN, 34));
		panTop.add(label);
		
		JButton loginButton = new JButton("Log in");
		panBottom.add(loginButton);
		
		JLabel labelUserID = new JLabel("UserID:");
		JTextField txtUserID = new JTextField(10);
		panLeft.add(labelUserID, BorderLayout.NORTH);
		panLeft.add(txtUserID, BorderLayout.CENTER);
		
		JLabel labelPassword = new JLabel("Password:");
		JTextField txtPassword = new JTextField(10);
		panRight.add(labelPassword, BorderLayout.NORTH);
		panRight.add(txtPassword, BorderLayout.CENTER);
		
		jframe.setContentPane(panOuter);
		jframe.setSize(600, 200);
		jframe.pack();
		jframe.setVisible(true);
	}
}
