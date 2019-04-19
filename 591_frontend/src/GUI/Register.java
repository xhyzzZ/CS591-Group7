package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Register extends JPanel{
	private JLabel registerLabel, usernameLabel, passwordLabel;
	private static Font labelFont = new Font("Dialog", Font.BOLD, 14);
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton confirmButton, cancelButton;
	
	public Register() {
		super(null);
		registerLabel = new JLabel("Register");
		registerLabel.setFont(labelFont);
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setVerticalAlignment(SwingConstants.CENTER);
		registerLabel.setBounds(150, 10, 200, 50);
		
		usernameLabel = new JLabel("username:");
		usernameLabel.setVerticalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(75, 85, 200, 50);
		
		passwordLabel = new JLabel("password:");
		passwordLabel.setVerticalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(75, 185, 200, 50);
		
		usernameField = new JTextField();
		usernameField.setToolTipText("Enter your username");
		usernameField.setBounds(225, 85, 200, 50);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(225, 185, 200, 50);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setToolTipText("Confirm your account");
		confirmButton.setBounds(275, 285, 150, 50);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setToolTipText("Canel your account");
		cancelButton.setBounds(75, 285, 150, 50);
		
		this.add(registerLabel);
		this.add(usernameLabel);
		this.add(passwordLabel);
		this.add(usernameField);
		this.add(passwordField);
		this.add(confirmButton);
		this.add(cancelButton);
		
	}
	
	public JLabel getRegisterLabel() {
		return this.registerLabel;
	}
	
	public JLabel getUsernameLabel() {
		return this.usernameLabel;
	}
	
	public JLabel getPasswordLabel() {
		return this.passwordLabel;
	}
	
	public JTextField getUsernameField() {
		return this.usernameField;
	}
	
	public JPasswordField getPasswordField() {
		return this.passwordField;
	}
	
	public JButton getConfirmButton() {
		return this.confirmButton;
	}
	
	public JButton getCancelButton() {
		return this.cancelButton;
	}
	
}

