package GUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JPanel{
	private JLabel loginLabel, usernameLabel, passwordLabel;
	private static Font labelFont = new Font("Dialog", Font.BOLD, 14);
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton, registerButton;
	
	public Login() {
		super(null);
		
		loginLabel = new JLabel("Login");
		loginLabel.setFont(labelFont);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setVerticalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(150, 10, 200, 50);
		
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
		
		loginButton = new JButton("Login");
		loginButton.setToolTipText("Login to your account");
		loginButton.setBounds(275, 285, 150, 50);
		
		registerButton = new JButton("Register");
		registerButton.setToolTipText("Register your account");
		registerButton.setBounds(75, 285, 150, 50);
		
		this.add(loginLabel);
		this.add(usernameLabel);
		this.add(passwordLabel);
		this.add(usernameField);
		this.add(passwordField);
		this.add(loginButton);
		this.add(registerButton);
		
	}
	
	public JLabel getLoginLabel() {
		return this.loginLabel;
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
	
	public JButton getLoginButton() {
		return this.loginButton;
	}
	
	public JButton getRedisterButton() {
		return this.registerButton;
	}
	
}


