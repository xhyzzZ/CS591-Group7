package GUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class Login extends JPanel{
	private JLabel loginLabel, usernameLabel, passwordLabel, imageLabel;
	private static Font labelFont = new Font("Dialog", Font.PLAIN, 20);
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 50);
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton, registerButton;
	
	
//	public static void main(String[] args) {
//		new Login();
//		JFrame f=new JFrame();
//		Toolkit tk  = Toolkit.getDefaultToolkit();
//		int x = ((int)tk.getScreenSize().getWidth());
//		int y = ((int)tk.getScreenSize().getHeight());
//		f.setSize(x, y);
//		JPanel p=new Login();
//		p.setBounds(100, 100, 800, 800);
//		f.add(p);
//		f.setSize(1000, 1000);
//		f.setResizable(false);
//		//f.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		f.setLocationRelativeTo(null);
//		f.setVisible(true);
//		
//	}
	
	public Login() {
		super();
		
		Toolkit tk  = Toolkit.getDefaultToolkit();
		int x = ((int)tk.getScreenSize().getWidth());
		int y = ((int)tk.getScreenSize().getHeight());
		//System.out.println(x +" " + y);
		loginLabel = new JLabel("Login");
		loginLabel.setFont(labelFont_big);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setVerticalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(520, 200, 400, 100);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(labelFont);
		usernameLabel.setVerticalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(570, 300, 200, 100);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(labelFont);
		passwordLabel.setVerticalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(570, 400, 200, 50);
		
//		imageLabel = new JLabel(new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/src/img/Login.png"));
//		imageLabel.setBounds(100, 100, 100, 100);
		
		usernameField = new JTextField();
		usernameField.setToolTipText("Enter your username");
		usernameField.setBounds(720, 330, 200, 50);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(720, 400, 200, 50);
		
		//loginButton = new JButton();
		loginButton = new JButton("Login", new ImageIcon("images/Login2.png"));
		//loginButton.setIcon(new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/src/img/Login.png"));
		//loginButton.setBorder(null);
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
		
		this.add(loginLabel);
		//this.add(imageLabel);
		this.add(usernameLabel);
		MyPanel pp=new MyPanel();
		pp.setPic("images/BU.png");
		pp.setBounds(520, 0, 400, 200);
		this.add(pp);
		this.add(passwordLabel);
		this.add(usernameField);
		this.add(passwordField);
		this.add(loginButton);
		this.add(registerButton);
		this.setLayout(null);
		//this.add(new JLabel(new ImageIcon("img/Login.png")));
		validate();
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



