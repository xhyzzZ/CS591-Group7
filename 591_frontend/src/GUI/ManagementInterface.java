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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ManagementInterface extends JPanel {
	private JButton addassignmentButton, addNote, total, showStatistic, addrowButton, deletecolButton, deletestudentButton, closecourseButton, exitButton, exporttocsvButton, deletesheetButton, saveasmodelButton, savesheetButton;
	private JPanel managementPanel;
	private JScrollPane scrollPane;
	private JTextArea ta;
	private JLabel noteLabel;
	//private JScrollPane scrollPane = new JScrollPane();
//	String[] columnNames = {"First Name",
//            "Last Name",
//            "Sport",
//            "# of Years",
//            "Vegetarian"};
//	Object[][] data = {
//		    {"Kathy", "Smith",
//		     "Snowboarding", new Integer(5), new Boolean(false)},
//		    {"John", "Doe",
//		     "Rowing", new Integer(3), new Boolean(true)},
//		    {"Sue", "Black",
//		     "Knitting", new Integer(2), new Boolean(false)},
//		    {"Jane", "White",
//		     "Speed reading", new Integer(20), new Boolean(true)},
//		    {"Joe", "Brown",
//		     "Pool", new Integer(10), new Boolean(false)}
//		};
	private DefaultTableModel d;
//
    private JTable managementTable ;
    private JButton b;
	public ManagementInterface(DefaultTableModel d,JButton b) {		
		super(null);
		this.b=b;
		managementPanel=new JPanel();
		this.d=d;
		managementTable=new JTable(d);
		managementTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		managementTable.setFillsViewportHeight(true);
		managementTable.setRowHeight(30);
		
        scrollPane = new JScrollPane(managementTable);
   		
   		managementPanel.setBounds(110,130,1000,800);
   		
   		managementPanel.add(scrollPane);
   		//scrollPane.setFillsViewportHeight(true);

   		JPanel p1=new JPanel();
   		p1.setLayout(new GridLayout(8,1));
   		
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
		
		addNote = new JButton("Add Note");
		
		ta = new JTextArea();
		ta.setBounds(100, 600, 250, 150);
		ta.setText("aaa"+"\n"+"ppp");
		
		noteLabel = new JLabel("Note:");
		noteLabel.setBounds(50, 540, 50, 150);
		noteLabel.setVerticalAlignment(SwingConstants.CENTER);
       // managementTable.setFillsViewportHeight(true);
		//scrollPane.setViewportView(managementTable);	
		p1.add(addassignmentButton);
		p1.add(deletecolButton);
		p1.add(addrowButton);
		p1.add(deletestudentButton);
		p1.add(showStatistic);
		p1.add(total);
		p1.add(addNote);
		//p1.add(closecourseButton);
		//p1.add(deletesheetButton);
		//p1.add(exitButton);
		//p1.add(exporttocsvButton);
		//p1.add(saveasmodelButton);
		//p1.add(savesheetButton);
		p2.add(exitButton);
		p2.add(deletesheetButton);
		p2.add(closecourseButton);
		p2.add(exporttocsvButton);
		p2.add(saveasmodelButton);
		p2.add(savesheetButton);
		
		p1.setBounds(100,150,150,450);
		p2.setBounds(380, 600, 600, 100);
		this.add(p1);
		this.add(p2);
		this.add(ta);
		this.add(noteLabel);
		this.add(scrollPane);
		this.add(managementPanel);

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
	   };

		//System.out.println("ssss");
	    this.managementPanel.remove(scrollPane);
		//
		//scrollPane.add(new JTable(new DefaultTableModel(data1,cc)));
		//this.scrollPane.revalidate();
		//this.scrollPane.repaint();
		//this.managementTable=;
	    
	    d.setDataVector(data1,cc);
	    JTable n = new JTable(d);
	    this.managementTable = n;
	//	this.managementPanel.add();
		JScrollPane scroll = new JScrollPane(n);
		this.managementPanel.add(scroll);
		this.scrollPane=scroll;
		this.managementPanel.revalidate();
		this.b=nb;
	
	}
	
	public void update(String[] cn, Object[][] da) {  
		   this.managementPanel.remove(scrollPane);     
		      d.setDataVector(da,cn);
		      JTable n=new JTable(d);      
		      this.managementTable=n;
		  JScrollPane scroll = new JScrollPane(n);
		  this.managementPanel.add(scroll);
		  this.scrollPane=scroll;
		  this.managementPanel.revalidate(); 
		 }
	
}
