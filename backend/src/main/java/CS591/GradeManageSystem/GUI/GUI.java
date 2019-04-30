package CS591.GradeManageSystem.GUI;
import CS591.GradeManageSystem.Service.impl.*;
import CS591.GradeManageSystem.Service.impl.UserServiceImpl;
import CS591.GradeManageSystem.entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame{
	private Login loginPanel = new Login();
	private Register registerPanel=new Register();
	private Dashboard dashboardPanel= new Dashboard();
	private AddNewAssignment assignmentPanel= new AddNewAssignment();
	private AddNewCourse1 addcoursePanel= new AddNewCourse1(dashboardPanel.getcoursePanel());
	private Statistic staPanel= new Statistic();

	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
	private AssignmentServiceImpl assignmentServiceImpl = new AssignmentServiceImpl();
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
	private UnitServiceimpl unitServiceimpl = new UnitServiceimpl();
	private ModelServiceImpl modelService = new ModelServiceImpl();
	private StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();

	// current login user
	private User currentUser = null;

	// current course
	private Course currentCourse = null;

	// current assignments
	private List<Assignment> assignments = new ArrayList<>();

	// current student
	private List<Student> students = new ArrayList<>();

	// current units
	private Map<Assignment, Map<Student, Unit>> units = new HashMap<>();

	private JFrame frame;

	private DefaultTableModel dd;
	private ManagementInterface managePage;


	public static void main(String[] args) {
		new GUI();
	}

	public GUI(){
		frame = new JFrame();
		this.dd = new DefaultTableModel();
		this.managePage = new ManagementInterface(dd,null);

		frame.setTitle("Welcome to Grading System!");
		frame.setSize(1000, 800);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new CardLayout());

		frame.add(loginPanel);
		frame.add(registerPanel);
		frame.add(dashboardPanel);
		frame.add(assignmentPanel);
		frame.add(addcoursePanel) ;
		frame.add(managePage);
		frame.add(staPanel);

		loginPanel.setVisible(true);
		frame.setVisible(true);

		validate();

		// the login button
		loginPanel.getLoginButton().addActionListener(e -> {
			//check password
			String username = loginPanel.getUsernameField();
			String password = loginPanel.getPasswordField();

			int check = userServiceImpl.checkLogin(username, password);
			if(check == 1) {
				JOptionPane.showMessageDialog(loginPanel, "No such user!");
			} else if (check == 2) {
				JOptionPane.showMessageDialog(loginPanel, "Wrong password!");
			} else {
				currentUser = userServiceImpl.login(username, password);
				addcoursePanel.getCoursePanel().removeAll();
				for (Course cs : courseServiceImpl.getCourses(currentUser.getUserId())) {
					JButton name = new JButton(cs.getCourseName());
					addcoursePanel.getCoursePanel().add(name);
					name.addActionListener(e1 -> {
						dashboardPanel.setVisible(false);
						currentCourse = cs;
						update(name, cs);
					});
				}
				loginPanel.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});

		// open the register GUI
		loginPanel.getRedisterButton().addActionListener(e -> {
			loginPanel.setVisible(false);
			registerPanel.setVisible(true);
		});

		// return to the login GUI
		registerPanel.getCancelButton().addActionListener(e -> {
			registerPanel.setVisible(false);
			loginPanel.setVisible(true);
		});

		// the register button
		registerPanel.getConfirmButton().addActionListener(e -> {
			String username = registerPanel.getUsernameField();
			String password = registerPanel.getPasswordField();
			String confirm = registerPanel.getPasswordreField();
			int check = userServiceImpl.register(username, password, confirm);
			if(check == 1) {
				JOptionPane.showMessageDialog(registerPanel, "The user already exists!");
			} else if(check == 2) {
				JOptionPane.showMessageDialog(registerPanel, "Password is not the same!");
			} else {
				registerPanel.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});

		// logout button
		dashboardPanel.getlogoutButton().addActionListener(e -> {
			currentUser = null;
			dashboardPanel.setVisible(false);
			loginPanel.setVisible(true);
		});

		// open the add-new-course GUI
		dashboardPanel.getaddnewcourseButton().addActionListener(e -> {
			dashboardPanel.setVisible(false);
			addcoursePanel.setVisible(true);
		});

		// add new course
		addcoursePanel.getConfirmButton().addActionListener(e -> {
			int userId = currentUser.getUserId();
			String courseName = addcoursePanel.getCourseName();
			String year = addcoursePanel.getCourseYear();
			String moduleName = (String)addcoursePanel.getImportModule().getSelectedItem();
			moduleName = moduleName.toUpperCase();
			String semester = (String) addcoursePanel.getSemester().getSelectedItem();
			semester = semester.toUpperCase();
			Course cs = courseServiceImpl.createCourse(userId, courseName, year, semester, moduleName);

			JButton name = new JButton(cs.getCourseName());
			addcoursePanel.getCoursePanel().add(name);
			name.addActionListener(e1 -> {
				dashboardPanel.setVisible(false);
				currentCourse = cs;
				update(name, cs);
				managePage.setVisible(true);
			});

			addcoursePanel.setVisible(false);
			dashboardPanel.setVisible(true);
		});

		// return to the dashboard GUI
		addcoursePanel.getCancelButton().addActionListener(e -> {
			addcoursePanel.setVisible(false);
			dashboardPanel.setVisible(true);
		});

		// import from file
		addcoursePanel.getOpenButton().addActionListener(e -> {
			JFileChooser c = new JFileChooser();
			c.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int rVal = c.showSaveDialog(GUI.this);
			if(rVal == c.APPROVE_OPTION) {
				String name = c.getSelectedFile().getName();
				String dir = c.getCurrentDirectory().toString();
				System.out.println(name + "\n" + dir);
			}
			if(rVal == c.CANCEL_OPTION){
				System.out.println("You pressed cancel");
			}
		});

		// open add-assignment GUI
		managePage.getaddassignmentButton().addActionListener(e -> {
			managePage.setVisible(false);
			assignmentPanel.setVisible(true);
		});

		// delete a student
		managePage.deletestudentButton().addActionListener(e -> {
			int[] selRowIndexes = managePage.getTable().getSelectedRows();
			if(selRowIndexes == null || selRowIndexes.length == 0) JOptionPane.showMessageDialog(managePage, "Please select student first!");
			else{
				int t = JOptionPane.showConfirmDialog(managePage,"Are you sure to delete the student?");
				if (t == 0) {
					for(int i : selRowIndexes) {
						Student student = students.get(i);
						studentServiceImpl.deleteStudent(currentCourse.getCourseId(), student.getStudentId());
					}
					update(currentCourse);
					JOptionPane.showMessageDialog(managePage, "Succeed!");
				}
			}
		});

		// delete a column
		managePage.getdeletecolButton().addActionListener(e -> {
			//currentCourse.isEditable()
			int[] selColIndexes = managePage.getTable().getSelectedColumns();
			if (selColIndexes == null || selColIndexes.length == 0) JOptionPane.showMessageDialog(managePage, "Please select column first!");
			else {
				int t = JOptionPane.showConfirmDialog(managePage,"Are you sure to delete these column?");
				if(t == 0) {
					for (int i : selColIndexes) {
						Assignment assignment = assignments.get(i);
						assignmentServiceImpl.deleteById(currentCourse.getCourseId(), assignment.getAssignmentId());
					}

					update(currentCourse);
				}
			}
		});

		// add row
		managePage.getrowButton().addActionListener(e -> {
			Student student = studentServiceImpl.createStudent(currentCourse.getCourseId(), "");
			students.add(student);
			for (Assignment assignment : assignments) {
				unitServiceimpl.createUnit(currentCourse.getCourseId(),
						student.getStudentId(),
						assignment.getAssignmentId(),
						"",
						"");
			}
			update(currentCourse);
		});

		// close course
		managePage.getclosecourseButton().addActionListener(e -> {
			//read only
			int t=JOptionPane.showConfirmDialog(managePage,"Are you sure to close this course? If yes the data will be read-only!");
			if (t == 0) {
				currentCourse.setEditable(false);
				courseServiceImpl.update(currentCourse);
				managePage.getTable().setEnabled(false);
			}
		});

		// delete the course
		managePage.getdeletesheetButton().addActionListener(e -> {
			int t = JOptionPane.showConfirmDialog(managePage,"Are you sure to delete this whole table? ");
			if (t == 0) {
				courseServiceImpl.deleteCourse(currentCourse.getCourseId());
				currentCourse = null;
				dashboardPanel.getcoursePanel().remove(managePage.getb());
				managePage.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});

		// get the statistics
		managePage.getStatistic().addActionListener(e -> {
			managePage.setVisible(false);

			String[] forCombo;
			int colCount = managePage.getd().getColumnCount();
			forCombo = new String[colCount - 5];

			for(int i = 0, j = 5; j < colCount ; i++, j++) {
				forCombo[i] = managePage.getd().getColumnName(j);
			}

			staPanel.SetforCombo(forCombo);

			staPanel.setVisible(true);
		});

		// get Total
		managePage.getTotal().addActionListener(e -> {
			Assignment totalColumn = assignmentServiceImpl.createAssignment(currentCourse.getCourseId(), "Total", 0, 100, false, true, true);
			for (Student student : students) {
				double total = 0;
				for (int i = 5; i < assignments.size(); i++) {
					Assignment assignment = assignments.get(i);
					total += Integer.parseInt(units.get(assignment).get(student).getContent()) * ((assignment.getWeight() / 100.0));
				}
				unitServiceimpl.createUnit(currentCourse.getCourseId(), student.getStudentId(), totalColumn.getAssignmentId(), String.valueOf(total), "");
			}
			update(currentCourse);
		});

		// save sheet
		managePage.getsavesheetButton().addActionListener(e -> {
			DefaultTableModel m = managePage.getd();
			for(int i = 0; i < m.getRowCount(); i++) {
				for(int j = 0; j < m.getColumnCount(); j++) {
					String content = (String) m.getValueAt(i, j);
					Unit unit = units.get(assignments.get(j)).get(students.get(i));
					unit.setContent(content);
					unitServiceimpl.update(unit);
				}
			}
			update(currentCourse);
		});

		// save as model
		managePage.getsaveasmodelButton().addActionListener(e -> {
			String modelName = currentCourse.getCourseName() + " " + currentCourse.getYear() + " " + currentCourse.getType().toString();
			for (Assignment assignment : assignments) {
				modelService.createModel(modelName, assignment.getAssignmentName(), assignment.getWeight(), assignment.getMaxPoint(), assignment.isAddPoint(), assignment.isExtraBonus(), assignment.isFix());
			}
		});

		// save and exit sheet
		managePage.getexitButton().addActionListener(e -> {
			int t = JOptionPane.showConfirmDialog(managePage,"Are you sure to exit this chart? ");
			if (t == 0) {
				DefaultTableModel m = managePage.getd();
				for(int i = 0; i < m.getRowCount(); i++) {
					for(int j = 0; j < m.getColumnCount(); j++) {
						String content = (String) m.getValueAt(i, j);
						Unit unit = units.get(assignments.get(j)).get(students.get(i));
						unit.setContent(content);
						unitServiceimpl.update(unit);
					}
				}
				update(currentCourse);

				managePage.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});

		// return to the manage page
		staPanel.getBackButton().addActionListener(e -> {
			staPanel.setVisible(false);
			managePage.setVisible(true);
		});

		// calculate the row
		staPanel.getCalButton().addActionListener(e -> {
			int c = staPanel.getchooseHW().getSelectedIndex() + 5;
			Assignment assignment = assignments.get(c);
			double[] data = statisticsService.getStatistics(assignment.getAssignmentId(), currentCourse.getCourseId());
			double max = statisticsService.getMax(data);
			double min = statisticsService.getMin(data);
			double medium = statisticsService.getMedium(data);
			double mean = statisticsService.getMean(data);
			double stddev = statisticsService.getStdDev(data);

			String sb = "Max: " + max + "\n" +
					"Min: " + min + "\n" +
					"Medium: " + medium + "\n" +
					"Mean: " + mean + "\n" +
					"StdDev: " + stddev + "\n";
			JOptionPane.showMessageDialog(staPanel, sb);
		});

		assignmentPanel.getConfirmButton().addActionListener(e -> {
			int courseId = currentCourse.getCourseId();
			String assignmentName = assignmentPanel.getassignmentField();
			int weight = assignmentPanel.getpercentField();
			int maxPoint = assignmentPanel.getmaximumField();
			boolean addPoint = !assignmentPanel.getpointBox().isSelected();
			boolean extraBonus = false;
			boolean fix = false;

			Assignment assignment = assignmentServiceImpl.createAssignment(courseId, assignmentName, weight, maxPoint, addPoint, extraBonus, fix);
			assignmentPanel.setVisible(false);

			for (Student student : students) {
				unitServiceimpl.createUnit(currentCourse.getCourseId(), student.getStudentId(), assignment.getAssignmentId(), "0", "");
			}

			update(currentCourse);

			managePage.setVisible(true);
		});

		// return to the manage page
		assignmentPanel.getCancelButton().addActionListener(e -> {
			assignmentPanel.setVisible(false);
			managePage.setVisible(true);
		});
	}

	public void update(JButton name, Course cs) {
		assignments = assignmentServiceImpl.getAssignments(cs.getCourseId());
		students = studentServiceImpl.getStudents(cs.getCourseId());
		units = unitServiceimpl.getUnits(cs.getCourseId());

		String[] as = assignmentServiceImpl.getAssignmentsName(cs.getCourseId());

		String[][] us = unitServiceimpl.getUnitContents(cs.getCourseId());
		managePage.update(name, as, us);

		managePage.setVisible(true);
	}

	public void update(Course cs) {
		assignments = assignmentServiceImpl.getAssignments(cs.getCourseId());
		students = studentServiceImpl.getStudents(cs.getCourseId());
		units = unitServiceimpl.getUnits(cs.getCourseId());

		String[] as = assignmentServiceImpl.getAssignmentsName(cs.getCourseId());

		String[][] us = unitServiceimpl.getUnitContents(cs.getCourseId());
		managePage.update(as, us);

		managePage.setVisible(true);
	}
}



