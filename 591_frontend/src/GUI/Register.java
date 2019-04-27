package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Register extends JPanel{
	private JLabel registerLabel, usernameLabel, passwordLabel, passwordreLabel;
	private static Font labelFont = new Font("Dialog", Font.BOLD, 20);
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 24);
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordreField;
	private JButton confirmButton, cancelButton;
	
	public Register() {
		super(null);
		registerLabel = new JLabel("Register");
		registerLabel.setFont(labelFont_big);
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setVerticalAlignment(SwingConstants.CENTER);
		registerLabel.setBounds(400, 100, 200, 50);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(labelFont);
		usernameLabel.setVerticalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(330, 200, 200, 50);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(labelFont);
		passwordLabel.setVerticalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(330, 270, 200, 50);
		
		passwordreLabel = new JLabel("Type it again:");
		passwordreLabel.setFont(labelFont);
		passwordreLabel.setVerticalAlignment(SwingConstants.CENTER);
		passwordreLabel.setBounds(330, 340, 200, 50);
		
		usernameField = new JTextField();
		usernameField.setToolTipText("Enter your username");
		usernameField.setBounds(480, 200, 200, 50);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(480, 270, 200, 50);
		
		passwordreField = new JPasswordField();
		passwordreField.setToolTipText("Please reenter your password");
		passwordreField.setBounds(480, 340, 200, 50);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setToolTipText("Confirm your account");
		confirmButton.setBounds(330, 410, 150, 50);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setToolTipText("Canel your account");
		cancelButton.setBounds(530, 410, 150, 50);
		
		this.add(registerLabel);
		this.add(usernameLabel);
		this.add(passwordLabel);
		this.add(passwordreLabel);
		this.add(passwordreField);
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

