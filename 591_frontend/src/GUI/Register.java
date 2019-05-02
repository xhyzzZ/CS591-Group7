package GUI;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Register extends MyPanel{
	private JLabel registerLabel, usernameLabel, passwordLabel, passwordreLabel;
	private static Font labelFont = new Font("Dialog", Font.PLAIN, 20);
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 50);
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordreField;
	private JButton confirmButton, cancelButton;
	
	public Register() {
		super();
		registerLabel = new JLabel("Register");
		registerLabel.setFont(labelFont_big);
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setVerticalAlignment(SwingConstants.CENTER);
		registerLabel.setBounds(520, 200, 400, 100);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(labelFont);
		usernameLabel.setVerticalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(570, 300, 200, 50);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(labelFont);
		passwordLabel.setVerticalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(570, 400, 200, 50);
		
		passwordreLabel = new JLabel("Type it again:");
		passwordreLabel.setFont(labelFont);
		passwordreLabel.setVerticalAlignment(SwingConstants.CENTER);
		passwordreLabel.setBounds(570, 500, 200, 50);
		
		usernameField = new JTextField();
		usernameField.setToolTipText("Enter your username");
		usernameField.setBounds(720, 300, 200, 50);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(720, 400, 200, 50);
		
		passwordreField = new JPasswordField();
		passwordreField.setToolTipText("Please reenter your password");
		passwordreField.setBounds(720, 500, 200, 50);
		
		confirmButton = new JButton("Confirm", new ImageIcon("images/Confirm.png"));
		confirmButton.setToolTipText("Confirm your account");
		confirmButton.setFont(labelFont);
		confirmButton.setHorizontalTextPosition(SwingConstants.CENTER);
		confirmButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		confirmButton.setVerticalAlignment(SwingConstants.CENTER);
		confirmButton.setBounds(550, 600, 130, 100);
		
		cancelButton = new JButton("Cancel", new ImageIcon("images/Cancel.png"));
		cancelButton.setToolTipText("Canel your account");
		cancelButton.setFont(labelFont);
		cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
		cancelButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		cancelButton.setVerticalAlignment(SwingConstants.CENTER);
		cancelButton.setBounds(790, 600, 130, 100);
		
		MyPanel p = new MyPanel();
		p.setPic("images/BU.png");
		p.setBounds(520, 0, 400, 200);
		this.add(p);
		this.add(registerLabel);
		this.add(usernameLabel);
		this.add(passwordLabel);
		this.add(passwordreLabel);
		this.add(passwordreField);
		this.add(usernameField);
		this.add(passwordField);
		this.add(confirmButton);
		this.add(cancelButton);
		this.setLayout(null);
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


