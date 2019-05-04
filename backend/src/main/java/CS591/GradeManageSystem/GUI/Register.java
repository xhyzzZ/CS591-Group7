package CS591.GradeManageSystem.GUI;

import java.awt.Font;

import javax.swing.*;

public class Register extends JPanel {
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

		confirmButton = new JButton("Confirm");
		confirmButton.setToolTipText("Confirm your account");
		confirmButton.setBounds(330, 410, 150, 50);

		cancelButton = new JButton("Cancel");
		cancelButton.setToolTipText("Canel your account");
		cancelButton.setBounds(530, 410, 150, 50);

		confirmButton = new JButton("", new ImageIcon("images/Confirm2.png"));
		confirmButton.setToolTipText("Confirm your account");
		confirmButton.setFont(labelFont);
		confirmButton.setHorizontalTextPosition(SwingConstants.CENTER);
		confirmButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		confirmButton.setVerticalAlignment(SwingConstants.CENTER);
		confirmButton.setBounds(550, 600, 130, 70);

		cancelButton = new JButton("", new ImageIcon("images/Cancel2.png"));
		cancelButton.setToolTipText("Canel your account");
		cancelButton.setFont(labelFont);
		cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
		cancelButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		cancelButton.setVerticalAlignment(SwingConstants.CENTER);
		cancelButton.setBounds(790, 600, 130, 70);

		MyPanel p = new MyPanel();
		p.setPic("images/BU.png");
		p.setBounds(570, 50, 350, 150);

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

	}

	public String getUsernameField() {
		return this.usernameField.getText();
	}

	public String getPasswordField() {
		return String.valueOf(this.passwordField.getPassword());
	}

	public String getPasswordreField() {
		return String.valueOf(this.passwordreField.getPassword());
	}

	public JButton getConfirmButton() {
		return this.confirmButton;
	}

	public JButton getCancelButton() {
		return this.cancelButton;
	}

}

