package GUI;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class GUI extends JFrame{
	private Login loginPanel;
	private Register registerPanel;
	private Dashboard dashboardPanel;
	
	public static void main(String[] args) {
		new GUI();
	}
	
	public GUI() {
		this.setVisible(true);
		this.setTitle("ATM");
		this.setSize(500, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new CardLayout());
		this.add(loginPanel = new Login());
		this.add(registerPanel = new Register());
		this.add(dashboardPanel = new Dashboard());
		//this.add(test = new JButton("Test"));
		//test.setBounds(100, 100, 150, 60);
		//loginPanel.setVisible(true);
		loginPanel.getLoginButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				dashboardPanel.setVisible(true);
				
			}
		});
		
		loginPanel.getRedisterButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				registerPanel.setVisible(true);
			}
		});
		
		registerPanel.getCancelButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		
		registerPanel.getConfirmButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerPanel.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});
		
		dashboardPanel.getlogoutButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		
		dashboardPanel.getaddnewcourseButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(false);
				
			}
		});
		
	}

}
