/*package GUI;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ManagementInterface extends JPanel{
	private JButton addassignmentButton, deletecolButton, deletestudentButton, closecourseButton, exitButton, exporttocsvButton, deletesheetButton, saveasmodelButton, savesheetButton;
	private JPanel managementPanel;
	private JTable managementTable;
	private JScrollPane scrollPane = new JScrollPane();
	
	public ManagementInterface() {
		super(null);
		addassignmentButton = new JButton("Add Assignment");
		addassignmentButton.setBounds(40, 50, 140, 50);
		
		deletecolButton = new JButton("Delete Column");
		deletecolButton.setBounds(180, 50, 140, 50);
		
		deletestudentButton = new JButton("Delete Student");
		deletestudentButton.setBounds(320, 50, 140, 50);
		
		closecourseButton = new JButton("Close Course");
		closecourseButton.setBounds(460, 50, 140, 50);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(40, 300, 140, 50);
		
		exporttocsvButton = new JButton("Export to csv");
		exporttocsvButton.setBounds(180, 300, 140, 50);
		
		deletesheetButton = new JButton("Delete Sheet");
		deletesheetButton.setBounds(320, 300, 140, 50);
		
		saveasmodelButton = new JButton("Save as model");
		saveasmodelButton.setBounds(460, 300, 140, 50);
		
		savesheetButton = new JButton("Sace Sheet");
		savesheetButton.setBounds(480, 300, 140, 50);
		
		managementTable = new JTable();
		managementTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(managementTable);
		
		managementPanel = new JPanel();
		managementPanel.setBounds(130, 120, 240, 170);
		managementPanel.add(managementTable);
		
		this.add(addassignmentButton);
		this.add(deletecolButton);
		this.add(deletestudentButton);
		this.add(closecourseButton);
		this.add(exitButton);
		this.add(exporttocsvButton);
		this.add(deletesheetButton);
		this.add(saveasmodelButton);
		this.add(savesheetButton);
	}
	
	public JButton getaddassignmentButton() {
		return this.addassignmentButton;
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
	
	
}*/

package GUI;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ManagementInterface extends MyPanel {
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
//
    //private MyJTable managementTable ;
	private MyJTable managementTable;
    private JButton b;
	public ManagementInterface(DefaultTableModel d,JButton b) {	
		
		super();
		this.setPic("images/BU2.jpg");
		
		this.b=b;
		managementPanel=new JPanel();
		this.d=d;
		
		//managementTable=new MyJTable(d);
		managementTable=new MyJTable(d);
		managementTable.setPreferredScrollableViewportSize(new Dimension(800,800));
		managementTable.setFillsViewportHeight(true);
		managementTable.setRowHeight(50);
		managementTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		managementTable.setAutoCreateRowSorter(true);
		TableRowSorter<DefaultTableModel> sorter= new TableRowSorter<DefaultTableModel>(d); 
		managementTable.setRowSorter(sorter);
		managementTable.setCellSelectionEnabled(true);
		//RowSorter rowSorter = new TableRowSorter((TableModel)d);
		//managementTable.setRowSorter(rowSorter);
		//managementTable.setTableHeader();
		managementTable.getTableHeader().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int col = managementTable.columnAtPoint(e.getPoint());
		        String name = managementTable.getColumnName(col);
		        System.out.println("Column index selected " + col + " " + name);
		    }
		});
//		
		//managementPanel.setBounds(50, 50, 700, 600);
        scrollPane = new JScrollPane(managementTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//       
        scrollPane.add(managementTable);
        scrollPane.revalidate();
   		managementPanel.setBounds(100, 100, 800, 500);
   		managementPanel.setLayout(new BorderLayout());
   		//this.setLayout(new BorderLayout());
   		managementPanel.add(scrollPane, BorderLayout.CENTER);
   		
   		//scrollPane.setFillsViewportHeight(true);

   		JPanel p1=new JPanel();
   		p1.setLayout(new GridLayout(7,1));
   		
   		JPanel p2 = new JPanel();
   		p2.setLayout(new GridLayout(1,6));
   		
		addassignmentButton = new JButton("Add Assignment");
		addrowButton = new JButton("Add Row");
		deletecolButton = new JButton("Delete Column");
		deletestudentButton = new JButton("Delete Student");
		
		closecourseButton = new JButton("Close Course", new ImageIcon("images/Close.png"));
		closecourseButton.setHorizontalTextPosition(SwingConstants.CENTER);
		closecourseButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		closecourseButton.setVerticalAlignment(SwingConstants.CENTER);
		
		showStatistic = new JButton("Show Statistic");
		
		total = new JButton("Add total score");
		  
		exitButton = new JButton("Save and Exit", new ImageIcon("images/Exit.png"));
		exitButton.setHorizontalTextPosition(SwingConstants.CENTER);
		exitButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		exitButton.setVerticalAlignment(SwingConstants.CENTER);

		exporttocsvButton = new JButton("Export to csv", new ImageIcon("images/Csv.png"));
		exporttocsvButton.setHorizontalTextPosition(SwingConstants.CENTER);
		exporttocsvButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		exporttocsvButton.setVerticalAlignment(SwingConstants.CENTER);
		
		deletesheetButton = new JButton("Delete Sheet", new ImageIcon("images/Delete1.png"));
		deletesheetButton.setHorizontalTextPosition(SwingConstants.CENTER);
		deletesheetButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		deletesheetButton.setVerticalAlignment(SwingConstants.CENTER);

		saveasmodelButton = new JButton("Save as model", new ImageIcon("images/Model.png"));
		saveasmodelButton.setHorizontalTextPosition(SwingConstants.CENTER);
		saveasmodelButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		saveasmodelButton.setVerticalAlignment(SwingConstants.CENTER);
		
		savesheetButton = new JButton("Save Sheet", new ImageIcon("images/Save.png"));
		savesheetButton.setHorizontalTextPosition(SwingConstants.CENTER);
		savesheetButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		savesheetButton.setVerticalAlignment(SwingConstants.CENTER);
		
		updateAssignment = new JButton("Update Assignment");
		
		addNote = new JButton("Add Note");
		addNote.setBounds(560, 660, 450, 100);
		ta = new JTextArea();
		ta.setBounds(100, 660, 450, 100);
		ta.setText("aaa"+"\n"+"ppp");
		
		noteLabel = new JLabel("Note:");
		noteLabel.setBounds(50, 600, 50, 150);
		noteLabel.setVerticalAlignment(SwingConstants.CENTER);
		
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
        // managementTable.setFillsViewportHeight(true);
		//scrollPane.setViewportView(managementTable);	
		p1.add(addassignmentButton);
		p1.add(deletecolButton);
		p1.add(addrowButton);
		p1.add(deletestudentButton);
		p1.add(showStatistic);
		p1.add(total);
		//p1.add(addNote);
		p1.add(updateAssignment);
		p2.add(exitButton);
		p2.add(deletesheetButton);
		p2.add(closecourseButton);
		p2.add(exporttocsvButton);
		p2.add(saveasmodelButton);
		p2.add(savesheetButton);
		
		p1.setBounds(800,100,150,450);
		p2.setBounds(380, 700, 600, 100);
		this.add(p1);
		this.add(p2);
		this.add(addNote);
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
	
	public MyJTable getTable() {
		return this.managementTable;
	}
	
//	public JTable getTable() {
//		return this.managementTable;
//	}
	
	public JButton getb() {
		return this.b;
	}
	
	public JTextArea getTa() {
		return this.ta;
	}
	
	public DefaultTableModel getd() {
		return d;
	}
	
	public void update(JButton nb) {
		System.out.println("aasdffhh");
		String[] cc = {"First Name",
	             "Last Name","test","test1"
	           };
		Object[][] data1 = {
	       {"Kathy", "Smith",
	         new Integer(5), new Integer(3)},
	       {"John", "Doe",
	         new Integer(3), new Integer(2)},
	       {"zhu", "kk",
		         new Integer(4), new Integer(6)}
	   };
		
	    this.managementPanel.remove(scrollPane);
		
	    
	    d.setDataVector(data1,cc);
	    MyJTable n = new MyJTable(d);
	    //JTable n = new JTable(d);
	    this.managementTable = n;
		JScrollPane scroll = new JScrollPane(n);
		this.managementPanel.add(scroll);
		this.scrollPane=scroll;
		this.revalidate();
		this.b=nb;
	
	}
	
	public void update(String[] cn, Object[][] da) {  
		   this.managementPanel.remove(scrollPane);     
		      d.setDataVector(da,cn);
		      MyJTable n=new MyJTable(d);
		      //JTable n=new JTable(d);  
		      this.managementTable=n;
		  JScrollPane scroll = new JScrollPane(n);
		  this.managementPanel.add(scroll);
		  this.scrollPane=scroll;
		  this.revalidate(); 
		 }
	
}

