package CS591.GradeManageSystem.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

public class Dashboard extends MyPanel{
	private JLabel dashboardLabel, userLabel;
	private JButton logoutButton, addnewcourseButton, cs591Button;
	private JPanel coursePanel;
	private static Font labelFont = new Font("Dialog", Font.PLAIN, 20);
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 50);
	private String s = new String();
	public Dashboard() {
		super(null);
		this.setPic("images/BU2.jpg");

		dashboardLabel  = new JLabel("Dashboard");
		dashboardLabel.setFont(labelFont_big);
		dashboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dashboardLabel.setVerticalAlignment(SwingConstants.CENTER);
		dashboardLabel.setBounds(520, 100, 400, 50);

		ImageIcon imgThisImg = new ImageIcon("images/User2.png");
		userLabel = new JLabel();
		userLabel.setIcon(imgThisImg);
		userLabel.setFont(labelFont);
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setVerticalAlignment(SwingConstants.CENTER);
		userLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		userLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		userLabel.setVerticalAlignment(SwingConstants.CENTER);
		userLabel.setBounds(1050, 50, 400, 200);

		logoutButton = new JButton("log out", new ImageIcon("images/Logout2.png"));
		logoutButton.setFont(labelFont);
		logoutButton.setHorizontalTextPosition(SwingConstants.CENTER);
		logoutButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		logoutButton.setVerticalAlignment(SwingConstants.CENTER);
		logoutButton.setToolTipText("Log out dahsboard");
		logoutButton.setBounds(150, 100, 130, 100);

		JLabel j = new JLabel("");
		j.setIcon(new ImageIcon("images/Open_big.png"));
		j.setBounds(660, 240, 200, 100);

		addnewcourseButton = new JButton("", new ImageIcon("images/Open_big.png"));
		addnewcourseButton.setFont(labelFont);
		addnewcourseButton.setHorizontalTextPosition(SwingConstants.CENTER);
		addnewcourseButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		addnewcourseButton.setVerticalAlignment(SwingConstants.CENTER);
		addnewcourseButton.setToolTipText("add new course to the system");
		addnewcourseButton.setBounds(620, 230, 200, 100);

		cs591Button = new JButton("", new ImageIcon("images/Open_big.png"));
		cs591Button.setHorizontalTextPosition(SwingConstants.CENTER);
		cs591Button.setVerticalTextPosition(SwingConstants.BOTTOM);
		cs591Button.setVerticalAlignment(SwingConstants.CENTER);

		coursePanel = new JPanel();
		coursePanel.setBounds(570, 340, 300, 400);
		coursePanel.setLayout(new GridLayout(0, 1, 0, 0));

		this.add(dashboardLabel);
		this.add(logoutButton);
		this.add(addnewcourseButton);
		this.add(coursePanel);
		this.add(userLabel);
		this.setLayout(null);
	}

	public JButton getlogoutButton() {
		return this.logoutButton;
	}

	public JButton getaddnewcourseButton() {
		return this.addnewcourseButton;
	}

	public JPanel getcoursePanel() {
		return this.coursePanel;
	}

	public JLabel getUserLabel() {
		return this.userLabel;
	}

	public void setUser(String s) {
		this.getUserLabel().setText(s);
	}

}

