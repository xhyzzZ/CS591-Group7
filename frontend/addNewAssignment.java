import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class addNewAssignment implements ActionListener{
	private JTextField  AssignmentName=new JTextField(30),pintotal=new JTextField(30),MaximumPoint=new JTextField(30);
	private JButton confirm=new JButton("confirm"),cancel=new JButton("cancel");
	private JLabel AssignmentName1=new JLabel("Assignment Name:");
	private JLabel pintotal1=new JLabel("Percent in total criterion(%):");
	private JLabel MaximumPoint1=new JLabel("Maximum points:");
	private JLabel deduct=new JLabel("Deduct points:");
	private JCheckBox deduct1=new JCheckBox();
	//private JComboBox importModule=new JComboBox();
	private JFrame frame;
	addNewAssignment(){
    	 JFrame frame=new JFrame("Add a new Assignment");  
    	 this.frame=frame;
    	 frame.setBounds(800,500,800,400);
    	 frame.setResizable(false);
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    	 confirm.addActionListener(this);
    	 cancel.addActionListener(this);
    		frame.setLayout(new GridLayout(2,2));
    		Panel  p1=new Panel();
    		p1.setLayout(new GridLayout(4,2));
    		p1.add(AssignmentName1);	
    		p1.add(AssignmentName);	
    		p1.add(pintotal1);	
    		p1.add(pintotal);	
    		p1.add(MaximumPoint1);	
    		p1.add(MaximumPoint);	
    		p1.add(deduct);	
    		p1.add(deduct1);	
    		
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
	public static void main(String[] a) {
		new addNewAssignment();
	}
}
