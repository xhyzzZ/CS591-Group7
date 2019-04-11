import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	private JTextField text2,text1;
	private JButton login,regis;
	
	
	public Login(){
	super("Welcome to Grading System!");
	this.setBounds(300,240,500,200);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.getContentPane().setLayout(new GridLayout(2,1));
	JPanel p=new JPanel(new GridLayout(2,2));
	p.add(new JLabel("Username:"));
    text1=new JTextField("",30);
    p.add(text1);
    p.add(new JLabel("Password:"));
    text2=new JTextField("",30);
    p.add(text2);
	this.getContentPane().add(p);
	JPanel p2=new JPanel();
    login=new JButton("Login");
    login.addActionListener(this);
 
    p2.add(login);
    p2.add(new JLabel("     First time here?=>"));
    regis=new JButton("Register");  
    regis.addActionListener(this);
    p2.add(regis);
    this.getContentPane().add(p2);
    this.setVisible(true); 
}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==regis) new RegisPage();
		
		if(e.getSource()==login) {
			new DashBoard();
		}	
	} 
	public static void main(String[] a) {
		new Login();
	}
	
	
}
