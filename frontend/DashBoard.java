import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DashBoard implements ActionListener{
	//private JTextField text2,text1;
	private JButton logout=new JButton("Log out"),addcourse=new JButton("Add Course");
	private JFrame frame;
     DashBoard(){
    	 JFrame frame=new JFrame("Dash Board");
    	 frame.setBounds(800,500,800,400);
    	 frame.setResizable(false);
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    	 frame.add(logout);
    	 frame.add(addcourse);
    	 logout.addActionListener(this);
    	 addcourse.addActionListener(this);
    	
    	 this.frame=frame; 
    	 frame.setVisible(true);
    }
     public void actionPerformed(ActionEvent e) {
    		if(e.getSource()==addcourse) {
    			new CreateNewCourse();

    		}
    		else frame.setVisible(false);   			
    		}

     public static void main(String[] a) {
 		new DashBoard();
 	}
     
    	}


