
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisPage extends JFrame implements ActionListener{
	JTextField name,pass;
	JButton confirm, cancel;
	
	public RegisPage(){
	super("Registeration");
	this.setBounds(800,500,800,400);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	name=new JTextField(30);
	pass=new JTextField(30);
	confirm=new JButton("confirm");
	confirm.addActionListener(this);
	cancel=new JButton("cancel");
	cancel.addActionListener(this);
	this.getContentPane().setLayout(new GridLayout(3,2));
	this.getContentPane().add(new JLabel("username:"));
	this.getContentPane().add(name);
	this.getContentPane().add(new JLabel("password:"));
	this.getContentPane().add(pass);
	this.getContentPane().add(confirm);
	this.getContentPane().add(cancel);
	this.setVisible(true);
	}
	
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==confirm) {

	}
	else this.setVisible(false);
		
	}

}
