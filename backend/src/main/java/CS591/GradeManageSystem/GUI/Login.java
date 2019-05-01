package CS591.GradeManageSystem.GUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JPanel {
	private JLabel loginLabel, usernameLabel, passwordLabel, imageLabel;
	private static Font labelFont = new Font("Dialog", Font.PLAIN, 20);
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 24);
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton, registerButton;

	public Login() {
		super(null);

		loginLabel = new JLabel("Login");
		loginLabel.setFont(labelFont_big);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setVerticalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(400, 100, 200, 50);

		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(labelFont);
		usernameLabel.setVerticalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(330, 200, 200, 50);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(labelFont);
		passwordLabel.setVerticalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(330, 300, 200, 50);

		imageLabel = new JLabel(new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/src/img/Login.png"));
		imageLabel.setBounds(100, 100, 100, 100);

		usernameField = new JTextField();
		usernameField.setToolTipText("Enter your username");
		usernameField.setBounds(460, 200, 200, 50);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(460, 300, 200, 50);

		//loginButton = new JButton();
		loginButton = new JButton("Login", new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/images/Login2.png"));
		//loginButton.setIcon(new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/src/img/Login.png"));
		//loginButton.setBorder(null);
		loginButton.setFont(labelFont);
		loginButton.setHorizontalTextPosition(SwingConstants.CENTER);
		loginButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		loginButton.setVerticalAlignment(SwingConstants.CENTER);
		loginButton.setToolTipText("Login to your account");
		loginButton.setBounds(330, 400, 130, 100);

		loginButton.addActionListener(e -> {

		});

		registerButton = new JButton("Register", new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/images/Register.png"));
		registerButton.setFont(labelFont);
		registerButton.setToolTipText("Register your account");
		registerButton.setHorizontalTextPosition(SwingConstants.CENTER);
		registerButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		registerButton.setVerticalAlignment(SwingConstants.CENTER);
		registerButton.setBounds(530, 400, 130, 100);

		this.add(loginLabel);
		//this.add(imageLabel);
		this.add(usernameLabel);
		this.add(passwordLabel);
		this.add(usernameField);
		this.add(passwordField);
		this.add(loginButton);
		this.add(registerButton);
		//this.add(new JLabel(new ImageIcon("img/Login.png")));
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


