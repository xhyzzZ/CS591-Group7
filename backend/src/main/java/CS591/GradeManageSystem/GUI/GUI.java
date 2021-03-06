package CS591.GradeManageSystem.GUI;
import CS591.GradeManageSystem.Service.impl.*;
import CS591.GradeManageSystem.Service.impl.UserServiceImpl;
import CS591.GradeManageSystem.entity.*;
import com.opencsv.CSVWriter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame{
	private static Login loginPanel = new Login();
	private static Register registerPanel = new Register();
	private static Dashboard dashboardPanel = new Dashboard();
	private static AddNewAssignment assignmentPanel = new AddNewAssignment();
	private static AddNewCourse1 addcoursePanel = new AddNewCourse1(dashboardPanel.getcoursePanel());
	private static Statistic staPanel = new Statistic();
	private static UpdateAssignment updateAssignment = new UpdateAssignment();

	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	private static CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
	private static AssignmentServiceImpl assignmentServiceImpl = new AssignmentServiceImpl();
	private static StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
	private static UnitServiceimpl unitServiceimpl = new UnitServiceimpl();
	private static ModelServiceImpl modelService = new ModelServiceImpl();
	private static StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();

	// current login user
	private static User currentUser = null;

	// current course
	private static Course currentCourse = null;

	// current assignments
	private static List<Assignment> assignments = new ArrayList<>();

	// current student
	private static List<Student> students = new ArrayList<>();

	// current units
	private static Map<Assignment, Map<Student, Unit>> units = new HashMap<>();

	// BufferReader
	private BufferedReader reader = null;

	// import path
	private String path;

	// import or not
	private boolean importOption;

	private JFrame frame;

	private DefaultTableModel dd;

	private static ManagementInterface managePage;

	public static void main(String[] args) {
		new GUI();
//		try {
//			UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
//			SwingUtilities.updateComponentTreeUI(new GUI());
//		} catch(Exception e) { /* Most of the time you're just going to ignore it */ }
	}

	public GUI() {
		frame = new JFrame();
		this.dd = new DefaultTableModel();
		this.managePage = new ManagementInterface(dd,null);

		frame.setTitle("Welcome to Grading System!");
		Toolkit tk  = Toolkit.getDefaultToolkit();
		int x = ((int)tk.getScreenSize().getWidth());
		int y = ((int)tk.getScreenSize().getHeight());
		frame.setSize(x, y);
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
		frame.add(updateAssignment);

		loginPanel.setVisible(true);
		frame.setVisible(true);

		validate();

		// the login button
		loginPanel.getLoginButton().addActionListener(e -> {
			//check password
			String username = loginPanel.getUsernameField();
			String password = loginPanel.getPasswordField();
			dashboardPanel.setUser(loginPanel.getUsernameField());

			int check = userServiceImpl.checkLogin(username, password);
			if(!username.equals("") && !password.equals("")) {
				if(check == 1) {
					JOptionPane.showMessageDialog(loginPanel, "No such user!");
				} else if (check == 2) {
					JOptionPane.showMessageDialog(loginPanel, "Wrong password!");
				} else {
					currentUser = userServiceImpl.login(username, password);
					addcoursePanel.getCoursePanel().removeAll();
					for (Course cs : courseServiceImpl.getCourses(currentUser.getUserId())) {
						JButton name = new JButton(cs.getCourseName() + " " + cs.getYear() + " " + cs.getType().toString());
						addcoursePanel.getCoursePanel().add(name);
						name.addActionListener(e1 -> {
							dashboardPanel.setVisible(false);
							managePage.setVisible(true);
							currentCourse = cs;
							managePage.getManagementPanel().setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
									cs.getCourseName() + "/" + cs.getYear() + "/" + cs.getType().toString(),
									TitledBorder.CENTER,
									TitledBorder.TOP));
							update(name, cs);
						});
					}
					loginPanel.setVisible(false);
					dashboardPanel.getUserLabel().setText("Hi! " + currentUser.getUsername());
					dashboardPanel.setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(loginPanel, "Username or password is empty!");
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
		// the register button
		registerPanel.getConfirmButton().addActionListener(e -> {

			String username = registerPanel.getUsernameField();
			String password = registerPanel.getPasswordField();
			String confirm = registerPanel.getPasswordreField();
			int check = userServiceImpl.register(username, password, confirm);
			if(!username.equals("") && !password.equals("") && !confirm.equals("")) {
				if(check == 1) {
					JOptionPane.showMessageDialog(registerPanel, "The user already exists!");
				} else if(check == 2) {
					JOptionPane.showMessageDialog(registerPanel, "Password is not the same!");
				} else {
					registerPanel.setVisible(false);
					loginPanel.setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(registerPanel, "Username or password cannot be empty!");
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
			List<Model> models = modelService.findByUserId(currentUser.getUserId());
			List<String> names = new ArrayList<>();
			for (int i = 0; i < models.size(); i++) {
				if (i == 0) names.add(models.get(i).getModelName());
				else {
					if (!models.get(i).getModelName().equals(models.get(i - 1).getModelName())) {
						names.add(models.get(i).getModelName());
					}
				}
			}

			String[] modelNames = names.toArray(new String[names.size()]);
			addcoursePanel.setImportModule(modelNames);
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

			if(!courseName.equals("") && !year.equals("")) {
				if (importOption) {
					try {
						reader = new BufferedReader(new FileReader(path));
						String line;
						while ((line = reader.readLine()) != null) {
							String[] content = line.split("\\s+");
							Student student = studentServiceImpl.createStudent(cs.getCourseId(), "");
							List<Assignment> as = assignmentServiceImpl.getAssignments(cs.getCourseId());
							for (int i = 0; i < as.size(); i++) {
								if (i < content.length) {
									unitServiceimpl.createUnit(cs.getCourseId(), student.getStudentId(), as.get(i).getAssignmentId(), content[i], "");
								} else {
									unitServiceimpl.createUnit(cs.getCourseId(), student.getStudentId(), as.get(i).getAssignmentId(), "", "");
								}
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				// clear import info
				importOption = false;
				path = null;

				JButton name = new JButton(cs.getCourseName() + " " + cs.getYear() + " " + cs.getType().toString());
				addcoursePanel.getCoursePanel().add(name);
				name.addActionListener(e1 -> {
					dashboardPanel.setVisible(false);
					currentCourse = cs;
					managePage.getManagementPanel().setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
							cs.getCourseName() + "/" + cs.getYear() + "/" + cs.getType().toString(),
							TitledBorder.CENTER,
							TitledBorder.TOP));
					update(name, cs);
					managePage.setVisible(true);
				});

				addcoursePanel.setVisible(false);
				dashboardPanel.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(addcoursePanel, "Please input information");
			}
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
				path = dir + "/" + name;
				importOption = true;
			}
		});

		// open add-assignment GUI
		managePage.getaddassignmentButton().addActionListener(e -> {
			if (!currentCourse.isEditable()) {
				JOptionPane.showMessageDialog(managePage, "This course is close!");
				return;
			}
			int sum = 0;
			for (Assignment assignment : assignments) {
				if (!assignment.isFix() && !assignment.isExtraBonus()) sum += assignment.getWeight();
			}
			assignmentPanel.getTotalPercentLabel().setText("Current Total: " + sum + "%");
			assignmentPanel.setAssignmentField("");
			assignmentPanel.setMaximumField("");
			assignmentPanel.setPercentField("");
			managePage.setVisible(false);
			assignmentPanel.setVisible(true);
		});

		// add assignment confirm
		assignmentPanel.getConfirmButton().addActionListener(e -> {
			int courseId = currentCourse.getCourseId();
			String assignmentName = assignmentPanel.getassignmentField();
			String weight = assignmentPanel.getpercentField();
			String maxPoint = assignmentPanel.getmaximumField();
			boolean addPoint = !assignmentPanel.getpointBox().isSelected();
			boolean extraBonus = assignmentPanel.getextraBox().isSelected();
			boolean fix = false;

			if(!assignmentName.equals("") && !maxPoint.equals("") && !weight.equals("")) {
				int sum = 0;
				for (Assignment assignment : assignments) {
					if (!assignment.isFix() && !assignment.isExtraBonus()) sum += assignment.getWeight();
				}

				int w = Integer.parseInt(weight);
				int s = Integer.parseInt(maxPoint);
				if (w + sum > 100) {
					//if weight plus sum is larger than 100, then show the message
					JOptionPane.showMessageDialog(managePage,"The total weight exceeds 100%");
					return;
				}

				Assignment assignment = assignmentServiceImpl.createAssignment(courseId, assignmentName, w, s, addPoint, extraBonus, fix);
				assignmentPanel.setVisible(false);

				for (Student student : students) {
					unitServiceimpl.createUnit(currentCourse.getCourseId(), student.getStudentId(), assignment.getAssignmentId(), "0", "");
				}

				update(currentCourse);

				managePage.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(assignmentPanel, "Information is not complete!");
			}


		});

		// return to the manage page
		assignmentPanel.getCancelButton().addActionListener(e -> {
			assignmentPanel.setVisible(false);
			managePage.setVisible(true);
		});

		// return to the manage page
		assignmentPanel.getCancelButton().addActionListener(e -> {
			assignmentPanel.setVisible(false);
			managePage.setVisible(true);
		});

		// delete a student
		// if not editable, return
		managePage.deletestudentButton().addActionListener(e -> {
			if (!currentCourse.isEditable()) {
				JOptionPane.showMessageDialog(managePage, "This course is close!");
				return;
			}
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
		// if not editable, return
		managePage.getdeletecolButton().addActionListener(e -> {
			if (!currentCourse.isEditable()) {
				JOptionPane.showMessageDialog(managePage, "This course is close!");
				return;
			}
			int[] selColIndexes = managePage.getTable().getSelectedColumns();
			for (int i : selColIndexes) {
				if (i < 6) {
					JOptionPane.showMessageDialog(managePage,"Cannot delete fix column");
					return;
				}
			}
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
		// if not editable, return
		managePage.getrowButton().addActionListener(e -> {
			if (!currentCourse.isEditable()) {
				JOptionPane.showMessageDialog(managePage, "This course is close!");
				return;
			}
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
		// if not editable, return
		managePage.getclosecourseButton().addActionListener(e -> {
			if (!currentCourse.isEditable()) return;
			int t = JOptionPane.showConfirmDialog(managePage,"Are you sure to close this course? If yes the data will be read-only!");
			if (t == 0) {
				currentCourse.setEditable(false);
				courseServiceImpl.update(currentCourse);
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

		// export csv model to local
		managePage.getexporttocsvButton().addActionListener(e -> {

			JFileChooser chooser = new JFileChooser();
			int option = chooser.showSaveDialog(null);

			if(option == JFileChooser.APPROVE_OPTION){ //假如用户选择了保存
				File file = chooser.getSelectedFile();

				try {
					// create FileWriter object with file as parameter
					FileWriter outputfile = new FileWriter(file);

					// create CSVWriter object filewriter object as parameter
					CSVWriter writer = new CSVWriter(outputfile);

					// the data we want to get
					List<String[]> all = new ArrayList<>();
					String[] assignment = new String[assignments.size()];
					for(int i = 0; i < assignments.size(); i++) {
						assignment[i] = assignments.get(i).getAssignmentName();
						// adding header to csv
					}
					all.add(assignment);
					writer.writeAll(all);

					String[] student = new String[assignments.size()];
					for(int i = 0; i < students.size(); i++) {
						for(int j = 0; j < assignments.size(); j++) {
							student[j] = units.get(assignments.get(j)).get(students.get(i)).getContent();
						}
						writer.writeNext(student);
					}

					// closing writer connection
					writer.close();

				} catch (IOException ee) {
					ee.printStackTrace();
				}
			}
		});

		// get the statistics
		managePage.getStatistic().addActionListener(e -> {
			managePage.setVisible(false);

			String[] forCombo;
			int colCount = managePage.getd().getColumnCount();
			forCombo = new String[colCount - 6];

			for(int i = 0, j = 6; j < colCount ; i++, j++) {
				forCombo[i] = managePage.getd().getColumnName(j);
			}

			staPanel.SetforCombo(forCombo);

			staPanel.setVisible(true);
		});

		// get Total
		// if not editable, return
		managePage.getTotal().addActionListener(e -> {
			if (!currentCourse.isEditable()) {
				JOptionPane.showMessageDialog(managePage, "This course is close!");
				return;
			}
			for (Assignment assignment : assignments) {
				if (assignment.getAssignmentName().equals("Total")) {
					assignmentServiceImpl.deleteById(currentCourse.getCourseId(), assignment.getAssignmentId());
				}
			}
			Assignment totalColumn = assignmentServiceImpl.createAssignment(currentCourse.getCourseId(), "Total", 0, 100, true, true, true);
			for (Student student : students) {
				double total = 0;
				try {
					for (int i = 6; i < assignments.size(); i++) {
						Assignment assignment = assignments.get(i);
						if (assignment.isExtraBonus()) continue;
						double grade = Math.abs(Double.parseDouble(units.get(assignment).get(student).getContent()));
						grade = assignment.isAddPoint() ? grade : assignment.getMaxPoint() - grade;
						total += grade * (assignment.getWeight() / 100.0);
					}
				} catch (Exception ex) {
					assignmentServiceImpl.deleteById(currentCourse.getCourseId(), totalColumn.getAssignmentId());
					JOptionPane.showMessageDialog(managePage, "Grade must be a number");
					return;
				}
				unitServiceimpl.createUnit(currentCourse.getCourseId(), student.getStudentId(), totalColumn.getAssignmentId(), String.valueOf(total), "");
			}
			update(currentCourse);
		});

		// save sheet
		// if not editable, return
		managePage.getsavesheetButton().addActionListener(e -> {
			if (!currentCourse.isEditable()) {
				update(currentCourse);
				JOptionPane.showMessageDialog(managePage, "This course is close!");
				return;
			}
			DefaultTableModel m = managePage.getd();
			for(int i = 0; i < m.getRowCount(); i++) {
				for(int j = 0; j < m.getColumnCount(); j++) {
					String content = (String) m.getValueAt(i, j);
					try {
						if (j >= 6 && !content.isEmpty()) {
							double grade = Double.parseDouble(content);
							int sign = assignments.get(j).isAddPoint() ? 1 : -1;
							grade = Math.abs(grade) > assignments.get(j).getMaxPoint() ? sign * assignments.get(j).getMaxPoint() : sign * Math.abs(grade);
							content = String.valueOf(grade);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(managePage, "Grade must be a number");
						return;
					}
					Unit unit = units.get(assignments.get(j)).get(students.get(i));
					unit.setContent(content);
					unitServiceimpl.update(unit);
				}
			}
		});

		// save as model
		managePage.getsaveasmodelButton().addActionListener(e -> {
			String modelName = currentCourse.getCourseName() + " " + currentCourse.getYear() + " " + currentCourse.getType().toString();
			List<Model> models = modelService.findByUserIdAndModelName(currentUser.getUserId(), modelName);
			for (Model model : models) {
				modelService.deleteModel(model.getModelId());
			}
			for (Assignment assignment : assignments) {
				if (!assignment.getAssignmentName().equals("Total")) {
					modelService.createModel(currentUser.getUserId(), modelName, assignment.getAssignmentName(), assignment.getWeight(), assignment.getMaxPoint(), assignment.isAddPoint(), assignment.isExtraBonus(), assignment.isFix());
				}
			}
		});

		// save and exit sheet
		managePage.getexitButton().addActionListener(e -> {
			int t = JOptionPane.showConfirmDialog(managePage,"Are you sure to exit this chart? ");
			if (t == 0) {
				if (currentCourse.isEditable()) {
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
				}

				managePage.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});

		// open update assignment
		managePage.getUpdateAssignment().addActionListener(e -> {
			if (!currentCourse.isEditable()) {
				JOptionPane.showMessageDialog(managePage, "This course is close!");
				return;
			}
			DefaultTableModel d = managePage.getd();
			int columncount = d.getColumnCount() - 6;
			String[] forCombo = new String[columncount];
			for(int i = 0, j = 6; i < columncount; i++, j++) {
				forCombo[i] = d.getColumnName(j);
			}
			updateAssignment.SetforCombo(forCombo);
			managePage.setVisible(false);
			updateAssignment.setVisible(true);
		});

		updateAssignment.getCancelButton().addActionListener(e -> {
			updateAssignment.setVisible(false);
			managePage.setVisible(true);
		});

		updateAssignment.getConfirmButton().addActionListener(e -> {

			int index = updateAssignment.getchooseHwBox().getSelectedIndex() + 6;
			String weight = updateAssignment.getpercentField().getText();
			String maxPoint = updateAssignment.getmaximumField().getText();
			boolean deduct = updateAssignment.getpointBox().isSelected();
			String name = updateAssignment.getassignmentField().getText();
			boolean extra = updateAssignment.getExtraBonusBox().isSelected();

			assignments.get(index).setWeight(Integer.parseInt(weight));
			assignments.get(index).setMaxPoint(Integer.parseInt(maxPoint));
			assignments.get(index).setAddPoint(!deduct);
			assignments.get(index).setAssignmentName(name);
			assignments.get(index).setExtraBonus(extra);
			assignmentServiceImpl.update(assignments.get(index));
			update(currentCourse);

			updateAssignment.setVisible(false);
			managePage.setVisible(true);
		});

		// add note
		managePage.getaddNote().addActionListener(e -> {
			if (!currentCourse.isEditable()) {
				JOptionPane.showMessageDialog(managePage, "This course is close!");
				return;
			}
			int colIndex = managePage.getTable().getSelectedColumn();
			int rowIndex = managePage.getTable().getSelectedRow();

			if(colIndex == -1 || rowIndex == -1) {
				JOptionPane.showMessageDialog(managePage, "Please select the cell first!");
			}
			else {
				String note = managePage.getTa().getText();
				Unit unit = units.get(assignments.get(colIndex)).get(students.get(rowIndex));
				unit.setNote(note);
				unitServiceimpl.update(unit);
			}
		});

		// save menu items
		managePage.getSaveMenuItem().addActionListener(e -> {
			update(currentCourse);
			if (!currentCourse.isEditable()) {
				JOptionPane.showMessageDialog(managePage, "This course is close!");
				return;
			} else {
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
			}
		});

		managePage.getSaveAsModelMenuItem().addActionListener(e -> {
			String modelName = currentCourse.getCourseName() + " " + currentCourse.getYear() + " " + currentCourse.getType().toString();
			List<Model> models = modelService.findByUserIdAndModelName(currentUser.getUserId(), modelName);
			for (Model model : models) {
				if (!modelName.equals("Total")) {
					modelService.deleteModel(model.getModelId());
				}
			}
			for (Assignment assignment : assignments) {
				modelService.createModel(currentUser.getUserId(), modelName, assignment.getAssignmentName(), assignment.getWeight(), assignment.getMaxPoint(), assignment.isAddPoint(), assignment.isExtraBonus(), assignment.isFix());
			}
		});

		// delete menu items
		managePage.getdeleteMenuItem().addActionListener(e -> {
			int t = JOptionPane.showConfirmDialog(managePage,"Are you sure to delete this whole table? ");
			if (t == 0) {
				courseServiceImpl.deleteCourse(currentCourse.getCourseId());
				currentCourse = null;
				dashboardPanel.getcoursePanel().remove(managePage.getb());
				managePage.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});

		// close course
		managePage.getclosecourseButton().addActionListener(e -> {
			if (!currentCourse.isEditable()) {
				JOptionPane.showMessageDialog(managePage, "You already close the course!");
				return;
			}
			int t = JOptionPane.showConfirmDialog(managePage,"Are you sure to close this course? If yes the data will be read-only!");
			if (t == 0) {
				currentCourse.setEditable(false);
				courseServiceImpl.update(currentCourse);
			}
		});

		// return to the manage page
		staPanel.getBackButton().addActionListener(e -> {
			staPanel.setVisible(false);
			managePage.setVisible(true);
		});

		// calculate the row
		staPanel.getCalButton().addActionListener(e -> {
			int c = staPanel.getchooseHW().getSelectedIndex() + 6;
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
	}

	// update for the course
	public static void update(JButton name, Course cs) {
		assignments = assignmentServiceImpl.getAssignments(cs.getCourseId());
		students = studentServiceImpl.getStudents(cs.getCourseId());
		units = unitServiceimpl.getUnits(cs.getCourseId());

		String[] as = assignmentServiceImpl.getAssignmentsName(cs.getCourseId());

		String[][] us = getUnits();
		managePage.update(name, as, us);
	}

	public static void update(Course cs) {
		assignments = assignmentServiceImpl.getAssignments(cs.getCourseId());
		students = studentServiceImpl.getStudents(cs.getCourseId());
		units = unitServiceimpl.getUnits(cs.getCourseId());

		String[] as = assignmentServiceImpl.getAssignmentsName(cs.getCourseId());

		String[][] us = getUnits();
		managePage.update(as, us);
	}

	// sort the course, then you can update the course
	public static void sortUpdate(Course cs) {
		String[] as = assignmentServiceImpl.getAssignmentsName(cs.getCourseId());
		String[][] us = getUnits();

		managePage.update(as, us);
	}

	public static String[][] getUnits() {
		String[][] res = new String[students.size()][assignments.size()];
		for (int i = 0; i < students.size(); i++) {
			for (int j = 0; j < assignments.size(); j++) {
				res[i][j] = unitServiceimpl.getUnit(assignments.get(j).getAssignmentId(), students.get(i).getStudentId()).getContent();
			}
		}

		return res;
	}

	public static String getNote(int r, int c) {
		return units.get(assignments.get(c)).get(students.get(r)).getNote();
	}

	//sort the column
	public static void sortByColumn(int c) {
		students.sort(Comparator.comparing(o -> units.get(assignments.get(c)).get(o).getContent()));
		sortUpdate(currentCourse);
	}
}



