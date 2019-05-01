package CS591.GradeManageSystem.GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddNewCourse1 extends JPanel{
	private JTextField  courseName=new JTextField(),courseID=new JTextField(),professorName=new JTextField(),courseYear=new JTextField();
	private JButton confirm=new JButton("confirm"),cancel=new JButton("cancel"), open = new JButton("open");
	private JLabel courseName1=new JLabel("Course Name:");
	private JLabel courseID1=new JLabel("Course ID:");
	private JLabel professorName1=new JLabel("Professor:");
	private JLabel courseYear1=new JLabel("Course Year:");
	private JLabel semester=new JLabel("Semester");
	private JLabel importFile = new JLabel("Import File:");
	private JLabel importModule1=new JLabel("Import Module:");
	private JComboBox semesterBox =new JComboBox(new String[]{"Spring", "Fall", "Summer"});;
	private JComboBox importModule = new JComboBox();
	private JPanel p;
	private static Font labelFont = new Font("Dialog", Font.PLAIN, 20);

	public AddNewCourse1(JPanel p){
		super(null);

		//JPanel panel = new JPanel();
		//panel.setSize(800, 1000);

		this.p=p;
		courseName1.setFont(labelFont);
		courseName1.setVerticalAlignment(SwingConstants.CENTER);
		courseName1.setBounds(730, 200, 200, 50);

		courseID1.setFont(labelFont);
		courseID1.setVerticalAlignment(SwingConstants.CENTER);
		courseID1.setBounds(230, 250, 200, 50);

		professorName1.setFont(labelFont);
		professorName1.setVerticalAlignment(SwingConstants.CENTER);
		professorName1.setBounds(330, 300, 200, 50);

		courseYear1.setFont(labelFont);
		courseYear1.setVerticalAlignment(SwingConstants.CENTER);
		courseYear1.setBounds(330, 350, 200, 50);

		semester.setFont(labelFont);
		semester.setVerticalAlignment(SwingConstants.CENTER);
		semester.setBounds(330, 400, 200, 50);

		importModule1.setFont(labelFont);
		importModule1.setVerticalAlignment(SwingConstants.CENTER);
		importModule1.setBounds(330, 450, 200, 50);

		importFile.setFont(labelFont);
		importFile.setVerticalAlignment(SwingConstants.CENTER);
		importFile.setBounds(330, 500, 200, 50);

		courseName.setFont(labelFont);
		courseName.setToolTipText("Enter course name.");
		courseName.setBounds(460, 200, 200, 50);

		courseID.setFont(labelFont);
		courseID.setToolTipText("Enter course ID.");
		courseID.setBounds(460, 300, 200, 50);

		professorName.setFont(labelFont);
		professorName.setToolTipText("Enter professor name.");
		professorName.setBounds(460, 300, 200, 50);

		courseYear.setFont(labelFont);
		courseYear.setToolTipText("Enter professor name.");
		courseYear.setBounds(460, 350, 200, 50);

		open.setFont(labelFont);
		open.setToolTipText("Choose file from computer");
		open.setBounds(460, 500, 200, 50);

		confirm.setFont(labelFont);
		confirm.setToolTipText("Confirm the course.");
		confirm.setBounds(510, 550, 200, 50);

		cancel.setFont(labelFont);
		cancel.setToolTipText("Cancel it.");
		cancel.setBounds(560, 550, 200, 50);

		semesterBox.setBounds(460, 400, 200, 50);

		importModule.setBounds(460, 450, 200, 50);

		this.setLayout(new GridLayout(2,2));
		Panel  p1=new Panel();
		p1.setLayout(new GridLayout(7,3));
		p1.add(courseName1);
		p1.add(courseName);
		p1.add(courseID1);
		p1.add(courseID);
		p1.add(professorName1);
		p1.add(professorName);
		p1.add(courseYear1);
		p1.add(courseYear);
		p1.add(semester);
		p1.add(semesterBox);
		p1.add(importModule1);
		p1.add(importModule);
		p1.add(importFile);
		p1.add(open);

		Panel  p2=new Panel();
		p2.add(confirm);
		p2.add(cancel);
		this.add(p1);
		this.add(p2);
		//this.add(panel);
		//panel.setVisible(true);
		validate();

	}
	public String getCourseName() {
		return this.courseName.getText();
	}

	public String getCourseYear() {
		return this.courseYear.getText();
	}

	public JComboBox getSemester() {
		return this.semesterBox;
	}

	public JComboBox getImportModule() {
		return this.importModule;
	}

	public void setImportModule(String[] models) {
		DefaultComboBoxModel model = new DefaultComboBoxModel(models);
		this.getImportModule().setModel(model);
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
