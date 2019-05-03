package CS591.GradeManageSystem.GUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.*;

public class Login extends JPanel {
	private JLabel loginLabel, usernameLabel, passwordLabel, imageLabel;
	private static Font labelFont = new Font("Dialog", Font.PLAIN, 20);
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 24);
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton, registerButton;

	public Login() {
		super(null);

		Toolkit tk  = Toolkit.getDefaultToolkit();
		int x = ((int)tk.getScreenSize().getWidth());
		int y = ((int)tk.getScreenSize().getHeight());
		loginLabel = new JLabel("Login");

		loginLabel.setFont(labelFont_big);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setVerticalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(520, 200, 400, 100);

		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(labelFont);
		usernameLabel.setVerticalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(560, 300, 200, 100);
		usernameLabel.setIcon(new ImageIcon("images/Login2.png"));

		passwordLabel = new JLabel("Password:");
		passwordLabel.setIcon(new ImageIcon("images/Lock2.png"));
		passwordLabel.setFont(labelFont);
		passwordLabel.setVerticalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(560, 400, 200, 50);

		usernameField = new JTextField();
		usernameField.setToolTipText("Enter your username");
		usernameField.setBounds(720, 330, 200, 50);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(720, 400, 200, 50);

		loginButton = new JButton("Login", new ImageIcon("images/Login2.png"));
		loginButton.setFont(labelFont);
		loginButton.setHorizontalTextPosition(SwingConstants.CENTER);
		loginButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		loginButton.setVerticalAlignment(SwingConstants.CENTER);
		loginButton.setToolTipText("Login to your account");
		loginButton.setBounds(550, 500, 130, 100);

		registerButton = new JButton("Register", new ImageIcon("images/Register.png"));
		registerButton.setFont(labelFont);
		registerButton.setToolTipText("Register your account");
		registerButton.setHorizontalTextPosition(SwingConstants.CENTER);
		registerButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		registerButton.setVerticalAlignment(SwingConstants.CENTER);
		registerButton.setBounds(790, 500, 130, 100);

		MyPanel pp=new MyPanel();
		pp.setPic("images/BU.png");
		pp.setBounds(570, 50, 350, 150);

		this.add(pp);
		this.add(loginLabel);
		this.add(usernameLabel);
		this.add(passwordLabel);
		this.add(usernameField);
		this.add(passwordField);
		this.add(loginButton);
		this.add(registerButton);
		validate();
	}

	public String getUsernameField() {
		return this.usernameField.getText();
	}

	public String getPasswordField() {
		return String.valueOf(this.passwordField.getPassword());
	}

	public JButton getLoginButton() {
		return this.loginButton;
	}

	public JButton getRedisterButton() {
		return this.registerButton;
	}

}


