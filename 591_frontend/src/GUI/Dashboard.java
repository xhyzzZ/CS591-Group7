package GUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

public class Dashboard extends JPanel{
	private JLabel dashboardLabel;
	private static Font labelFont = new Font("Dialog", Font.BOLD, 14);
	private JButton logoutButton, addnewcourseButton, cs591Button;
	private JPanel coursePanel;
	
	public Dashboard() {
		super(null);
		
		dashboardLabel  = new JLabel("Dashboard");
		dashboardLabel.setFont(labelFont);
		dashboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dashboardLabel.setVerticalAlignment(SwingConstants.CENTER);
		dashboardLabel.setBounds(150, 10, 200, 50);
		
		logoutButton = new JButton("log out");
		logoutButton.setToolTipText("Log out dahsboard");
		logoutButton.setBounds(40, 50, 150, 50);
		
		addnewcourseButton = new JButton("add new course");
		addnewcourseButton.setToolTipText("add new course to the system");
		addnewcourseButton.setBounds(305, 50, 150, 50);
		
		cs591Button = new JButton("CS 591 P1");
		
		coursePanel = new JPanel();
		coursePanel.setBounds(130, 120, 240, 170);
		coursePanel.setLayout(new GridLayout(0, 1, 0, 0));
		coursePanel.add(cs591Button);
		
		this.add(dashboardLabel);
		this.add(logoutButton);
		this.add(addnewcourseButton);
		this.add(coursePanel);
		
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
}
