package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddNewCourse1 extends JPanel{
	private JTextField  courseName=new JTextField(),courseYear=new JTextField();
	private JButton confirm=new JButton("confirm"),cancel=new JButton("cancel"), open = new JButton("open");
	private JLabel courseName1=new JLabel("Course Name:");
	//private JLabel courseID1=new JLabel("Course ID:");
	//private JLabel professorName1=new JLabel("Professor:");
	private JLabel courseYear1=new JLabel("Course Year:");
	private JLabel semester=new JLabel("Semester");
	private JLabel importFile = new JLabel("Import File:");
	private JLabel importModule1=new JLabel("Import Module:");
	private JComboBox semesterBox =new JComboBox(new String[]{"Spring", "Fall"});;
	private JComboBox importModule=new JComboBox(new String[]{"Default"});
	private JPanel p;
	private static Font labelFont = new Font("Dialog", Font.PLAIN, 20);
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 24);
	
	public AddNewCourse1(JPanel p){
		super(null);
		
    	 //JPanel panel = new JPanel();
    	 //panel.setSize(800, 1000);
    	 
    	 this.p=p;
//    	 Panel  p1=new Panel();
//    	 Panel  p2=new Panel();
    	 courseName1.setFont(labelFont);
    	 courseName1.setVerticalAlignment(SwingConstants.CENTER);
    	 courseName1.setBounds(520, 200, 200, 50);
    	 
    	 
    	 courseYear1.setFont(labelFont);
    	 courseYear1.setVerticalAlignment(SwingConstants.CENTER);
    	 courseYear1.setBounds(520, 250, 200, 50);
    	 
    	 semester.setFont(labelFont);
    	 semester.setVerticalAlignment(SwingConstants.CENTER);
    	 semester.setBounds(520, 300, 200, 50);
    	 
    	 importModule1.setFont(labelFont);
    	 importModule1.setVerticalAlignment(SwingConstants.CENTER);
    	 importModule1.setBounds(520, 350, 200, 50);
    	 
    	 importFile.setFont(labelFont);
    	 importFile.setVerticalAlignment(SwingConstants.CENTER);
    	 importFile.setBounds(520, 400, 200, 50);
    	 
    	 courseName.setFont(labelFont);
    	 courseName.setToolTipText("Enter course name.");
    	 courseName.setBounds(730, 200, 200, 50);
    	 
    	 courseYear.setFont(labelFont);
    	 courseYear.setToolTipText("Enter professor name.");
    	 courseYear.setBounds(730, 250, 200, 50);
    	 
    	 semesterBox.setBounds(730, 300, 200, 50);
    	 
    	 importModule.setBounds(730, 350, 200, 50);
    	 
    	 open.setFont(labelFont);
    	 open.setToolTipText("Choose file from computer");
    	 open.setBounds(730, 400, 200, 50);
    	 
    	 
    	 confirm.setFont(labelFont);
    	 confirm.setToolTipText("Confirm the course.");
    	 confirm.setBounds(550, 600, 130, 100);
    	 //confirm.setBackground(Color.GREEN);
    	 confirm.setOpaque(true);
    	 //confirm.setBorderPainted(false);
    	 //confirm.setForeground(Color.GRAY);
    	 
    	 cancel.setFont(labelFont);
    	 cancel.setToolTipText("Cancel it.");
    	 cancel.setBounds(790, 600, 130, 100);
    	 
    	 
    	 
    	 
    	 //this.setResizable(false);
    	// this.setDefaultCloseOperation(JPanel.EXIT_ON_CLOSE);	
    		//this.setLayout(new GridLayout(2,2));
    		
    		this.setLayout(null);
    		this.add(courseName1);	
    		this.add(courseName);	
    		this.add(courseYear1);	
    		this.add(courseYear);	
    		this.add(semester);
    		this.add(semesterBox);
    		this.add(importModule1);	
    		this.add(importModule);
    		this.add(importFile);
    		this.add(open);
    		this.setBounds(200, 100, 500, 500);
    		this.setBounds(300, 500, 100, 100);
    		//p2.setLayout(new BorderLayout());
    		this.add(confirm);	
    		this.add(cancel);
    		//this.setLayout(null);
//    		this.add(p1);
//    		
//    		this.add(p2);
    	 
    	 validate();
   
    }
	public JTextField getCourseName() {
		return this.courseName;
	}
	
	public JTextField getCourseYear() {
		return this.courseYear;
	}
	public JComboBox getImportModule() {
		return this.importModule;
	}

	public JButton getConfirmButton() {
		return this.confirm;
	}

	public JButton getCancelButton() {
		return this.cancel;
	}
	
	public JButton getOpenButton() {
		return this.open;
	}
	
	public JPanel getCoursePanel() {
		return this.p;
	}
	
}

