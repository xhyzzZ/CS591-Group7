package CS591.GradeManageSystem.GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ManagementInterface extends JPanel {
	private JButton addassignmentButton, addNote, total, showStatistic, addrowButton, deletecolButton, deletestudentButton, closecourseButton, exitButton, exporttocsvButton, deletesheetButton, saveasmodelButton, savesheetButton, updateAssignment;
	private JPanel managementPanel;
	private JScrollPane scrollPane;
	public static JTextArea ta;
	private JLabel noteLabel;
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu;
	private JMenuItem saveMenuItem;
	private JMenuItem exportToCsvMenuItem;
	private JMenuItem saveAsModelMenuItem;
	private JMenuItem deleteMenuItem;
	private JMenuItem closeCourseMenuItem;

	private DefaultTableModel d;
	private MyJTable managementTable;
	private JButton b;
	public ManagementInterface(DefaultTableModel d,JButton b) {
		super(null);
		this.b=b;
		managementPanel=new JPanel();
		this.d=d;

		managementTable = new MyJTable(d);
		managementTable.setPreferredScrollableViewportSize(managementTable.getPreferredSize());
		managementTable.setFillsViewportHeight(true);
		managementTable.setRowHeight(50);
		managementTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		managementTable.setAutoCreateRowSorter(true);
		RowSorter rowSorter = new TableRowSorter(d);
		managementTable.setRowSorter(rowSorter);

		scrollPane = new JScrollPane(managementTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.add(managementTable);
		scrollPane.revalidate();
		managementPanel.setBounds(10, 100, 1000, 800);
		managementPanel.setLayout(new BorderLayout());
		managementPanel.add(scrollPane, BorderLayout.CENTER);

		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(7,1));

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,6));

		addassignmentButton = new JButton("Add Assignment");
		addrowButton = new JButton("Add Row");
		deletecolButton = new JButton("Delete Column");
		deletestudentButton = new JButton("Delete Student");

		closecourseButton = new JButton("Close Course", new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/images/Close.png"));
		closecourseButton.setHorizontalTextPosition(SwingConstants.CENTER);
		closecourseButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		closecourseButton.setVerticalAlignment(SwingConstants.CENTER);

		showStatistic = new JButton("Show Statistic");

		total = new JButton("Add total score");

		exitButton = new JButton("Save and Exit", new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/images/Exit.png"));
		exitButton.setHorizontalTextPosition(SwingConstants.CENTER);
		exitButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		exitButton.setVerticalAlignment(SwingConstants.CENTER);

		exporttocsvButton = new JButton("Export to csv", new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/images/Csv.png"));
		exporttocsvButton.setHorizontalTextPosition(SwingConstants.CENTER);
		exporttocsvButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		exporttocsvButton.setVerticalAlignment(SwingConstants.CENTER);

		deletesheetButton = new JButton("Delete Sheet", new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/images/Delete1.png"));
		deletesheetButton.setHorizontalTextPosition(SwingConstants.CENTER);
		deletesheetButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		deletesheetButton.setVerticalAlignment(SwingConstants.CENTER);

		saveasmodelButton = new JButton("Save as model", new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/images/Model.png"));
		saveasmodelButton.setHorizontalTextPosition(SwingConstants.CENTER);
		saveasmodelButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		saveasmodelButton.setVerticalAlignment(SwingConstants.CENTER);

		savesheetButton = new JButton("Save Sheet", new ImageIcon("/Users/zhukaikang/eclipse-workspace/591_frontend/images/Save.png"));
		savesheetButton.setHorizontalTextPosition(SwingConstants.CENTER);
		savesheetButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		savesheetButton.setVerticalAlignment(SwingConstants.CENTER);

		updateAssignment = new JButton("Update Assignment");

		addNote = new JButton("Add Note");

		ta = new JTextArea();
		ta.setBounds(770, 600, 150, 100);

		noteLabel = new JLabel("Note:");
		noteLabel.setBounds(770, 550, 100, 90);
		noteLabel.setVerticalAlignment(SwingConstants.CENTER);

		addNote.setBounds(830,700,100,30);

		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		saveMenuItem = new JMenuItem("Save sheet");
		exportToCsvMenuItem = new JMenuItem("Export to csv");
		saveAsModelMenuItem = new JMenuItem("Save as model");
		deleteMenuItem = new JMenuItem("Delete sheet");
		closeCourseMenuItem = new JMenuItem("Close course");
		fileMenu.add(saveMenuItem);
		fileMenu.add(saveAsModelMenuItem);
		fileMenu.add(exportToCsvMenuItem);
		fileMenu.add(closeCourseMenuItem);
		editMenu.add(deleteMenuItem);

		p1.add(addassignmentButton);
		p1.add(deletecolButton);
		p1.add(addrowButton);
		p1.add(deletestudentButton);
		p1.add(showStatistic);
		p1.add(total);
		p1.add(updateAssignment);
		p2.add(exitButton);
		p2.add(deletesheetButton);
		p2.add(closecourseButton);
		p2.add(exporttocsvButton);
		p2.add(saveasmodelButton);
		p2.add(savesheetButton);

		p1.setBounds(1200,100,150,450);
		p2.setBounds(50, 560, 600, 80);
		this.add(p1);
		this.add(addNote);
		this.add(p2);
		this.add(ta);
		this.add(noteLabel);
		this.add(scrollPane);
		this.add(managementPanel);
		this.setLayout(new BorderLayout());
		this.add(menuBar, BorderLayout.NORTH);
	}

	public JButton getUpdateAssignment() {
		return this.updateAssignment;
	}

	public JMenuItem getSaveMenuItem() {
		return this.saveMenuItem;
	}

	public JMenuItem getExportToCsvMenuItem() {
		return this.exportToCsvMenuItem;
	}

	public JMenuItem getSaveAsModelMenuItem() {
		return this.saveAsModelMenuItem;
	}

	public JMenuItem getdeleteMenuItem() {
		return this.deleteMenuItem;
	}

	public JMenuItem getcloseCourseMenuItem() {
		return this.closeCourseMenuItem;
	}

	public JButton getaddassignmentButton() {
		return this.addassignmentButton;
	}

	public JButton getrowButton() {
		return this.addrowButton;
	}

	public JButton getdeletecolButton() {
		return this.deletecolButton;
	}

	public JButton deletestudentButton() {
		return this.deletestudentButton;
	}

	public JButton getclosecourseButton() {
		return this.closecourseButton;
	}

	public JButton getexitButton() {
		return this.exitButton;
	}

	public JButton getexporttocsvButton() {
		return this.exporttocsvButton;
	}

	public JButton getdeletesheetButton() {
		return this.deletesheetButton;
	}

	public JButton getsaveasmodelButton() {
		return this.addassignmentButton;
	}

	public JButton getsavesheetButton() {
		return this.savesheetButton;
	}

	public JButton getTotal() {
		return this.total;
	}

	public JButton getaddNote() {
		return this.addNote;
	}

	public JButton getStatistic() {
		return this.showStatistic;
	}

	public JTable getTable() {
		return this.managementTable;
	}

	public JButton getb() {
		return this.b;
	}

	public JTextArea getTa() {
		return this.ta;
	}

	public DefaultTableModel getd() {
		return d;
	}

	public void update(JButton button, String[] assignments, String[][] content) {
		this.managementPanel.remove(scrollPane);
		d.setDataVector(content, assignments);
		MyJTable n = new MyJTable(d);
		this.managementTable = n;
		JScrollPane scroll = new JScrollPane(n);
		this.managementPanel.add(scroll);
		this.scrollPane=scroll;
		this.managementPanel.revalidate();
		this.b = button;
	}

	public void update(String[] assignments, String[][] content) {
		this.managementPanel.remove(scrollPane);
		d.setDataVector(content, assignments);
		MyJTable n = new MyJTable(d);
		this.managementTable = n;
		JScrollPane scroll = new JScrollPane(n);
		this.managementPanel.add(scroll);
		this.scrollPane=scroll;
		this.managementPanel.revalidate();
	}
}

