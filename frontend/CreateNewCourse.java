import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CreateNewCourse implements ActionListener{
	private JTextField  courseName=new JTextField(30),courseID=new JTextField(30),professorName=new JTextField(30),courseYear=new JTextField(30);
	private JButton confirm=new JButton("confirm"),cancel=new JButton("cancel");
	private JLabel courseName1=new JLabel("Course Name:");
	private JLabel courseID1=new JLabel("Course ID:");
	private JLabel professorName1=new JLabel("Professor:");
	private JLabel courseYear1=new JLabel("Course Year:");
	private JLabel importModule1=new JLabel("Import Module:");
	private JComboBox importModule=new JComboBox();
	private JFrame frame;
	CreateNewCourse(){
    	 JFrame frame=new JFrame("Dash Board");  
    	 this.frame=frame;
    	 frame.setBounds(800,500,800,400);
    	 frame.setResizable(false);
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    	 confirm.addActionListener(this);
    	 cancel.addActionListener(this);
    		frame.setLayout(new GridLayout(2,2));
    		Panel  p1=new Panel();
    		p1.setLayout(new GridLayout(5,2));
    		p1.add(courseName1);	
    		p1.add(courseName);	
    		p1.add(courseID1);	
    		p1.add(courseID);	
    		p1.add(professorName1);	
    		p1.add(professorName);	
    		p1.add(courseYear1);	
    		p1.add(courseYear);	
    		p1.add(importModule1);	
    		p1.add(importModule);
    		Panel  p2=new Panel();
//    		p1.setLayout();
    		p2.add(confirm);	
    		p2.add(cancel);
    		frame.add(p1);
    		frame.add(p2);
    		frame.setVisible(true);
   
    }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==confirm) 
			new DashBoard();
			
		else 
			 this.frame.setVisible(false);
		
	}
//	public static void main(String[] a) {
//		new CreateNewCourse();
//	}
}
