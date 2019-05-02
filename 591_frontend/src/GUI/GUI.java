/*package GUI;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class GUI extends JFrame{
	private Login loginPanel;
	private Register registerPanel;
	private Dashboard dashboardPanel;
	private AddNewAssignment assignmentPanel;
	private AddNewCourse coursePanel;
	private ManagementInterface managementPanel;
	
	public static void main(String[] args) {
		new GUI();
	}
	
	public GUI() {
		
		this.setTitle("Welcome to Grading System");
		this.setSize(1000, 1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new CardLayout());
		this.add(loginPanel = new Login());
		this.setVisible(true);
		this.add(registerPanel = new Register());
		this.add(dashboardPanel = new Dashboard());
		this.add(assignmentPanel = new AddNewAssignment());
		this.add(coursePanel = new AddNewCourse());
		this.add(managementPanel = new ManagementInterface());
		//this.add(test = new JButton("Test"));
		//test.setBounds(100, 100, 150, 60);
		//loginPanel.setVisible(true);
		loginPanel.getLoginButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				dashboardPanel.setVisible(true);
				
			}
		});
		
		loginPanel.getRedisterButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				registerPanel.setVisible(true);
			}
		});
		
		registerPanel.getCancelButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		
		registerPanel.getConfirmButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		
		dashboardPanel.getlogoutButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		
		dashboardPanel.getaddnewcourseButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(false);
				coursePanel.setVisible(true);
			}
		});
		
		dashboardPanel.getcs591Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(false);
				managementPanel.setVisible(true);
			}
		}) ;
		
	}

}*/

package GUI;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Vector;

public class GUI extends JFrame{
	private Login loginPanel= new Login();
	private Register registerPanel=new Register();
	private Dashboard dashboardPanel= new Dashboard();
	private AddNewAssignment assignmentPanel= new AddNewAssignment();
	private AddNewCourse1 addcoursePanel= new AddNewCourse1(dashboardPanel.getcoursePanel());
	private Statistic staPanel= new Statistic();
	private UpdateAssignment updateAssignmentPanel = new UpdateAssignment();
	//!!!!!!
	private JFrame frame;
	
	String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};
	Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	private DefaultTableModel dd;
	public static ManagementInterface managePage;
	
	
	public static void main(String[] args) {
		try { 
	        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
			//UIManager.setLookAndFeel(
		            //UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
	    } catch(Exception ignored){}
		new GUI();
		Object a = 1;
		int b= Integer.parseInt(a.toString());
		//System.out.println(b+b);
	}
	
	public GUI(){
		frame = new JFrame();
		this.dd=new DefaultTableModel(data,columnNames);
		this.managePage=new ManagementInterface(dd,null);
		
		frame.setTitle("Welcome to Grading System!");
		Toolkit tk  = Toolkit.getDefaultToolkit();
		int x = ((int)tk.getScreenSize().getWidth());
		int y = ((int)tk.getScreenSize().getHeight());
		frame.setSize(x, y);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new CardLayout()); 
		
		frame.add(loginPanel );
		frame.add(registerPanel );
		frame.add(dashboardPanel );
		frame.add(assignmentPanel );
		frame.add(addcoursePanel) ;
		frame.add(managePage);
		frame.add(staPanel);
		frame.add(updateAssignmentPanel);
		loginPanel.setVisible(true);	
		frame.setVisible(true);
		
		validate();
		
		loginPanel.getLoginButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//check mima 
				//if() {
				//System.out.println(loginPanel.getUsernameField().getText());
				dashboardPanel.setUser(loginPanel.getUsernameField().getText());
				loginPanel.setVisible(false);
				dashboardPanel.setVisible(true);
				//else
				
			}
		});
		
		loginPanel.getRedisterButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginPanel.setVisible(false);
				registerPanel.setVisible(true);
			}
		});
		
		registerPanel.getCancelButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		
		registerPanel.getConfirmButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add xinxi check
			//	if{
				registerPanel.setVisible(false);
				//loginPanel.setVisible(true);
				dashboardPanel.setVisible(true);
//				}
//				else {
//					
//				}
			}
		});
		
		dashboardPanel.getlogoutButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		
		dashboardPanel.getaddnewcourseButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(false);
				addcoursePanel.setVisible(true);
			}
		});
		
		
		addcoursePanel.getConfirmButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//jia course xinxi
				JButton course=new JButton(addcoursePanel.getCourseName().getText());
				
				addcoursePanel.getCoursePanel().add(course);
				addcoursePanel.setVisible(false);
				dashboardPanel.setVisible(true);
				
				course.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					  dashboardPanel.setVisible(false);
					  //map string table after save put(updated table) map.get(course.getName())
					  managePage.update(course);
				      managePage.setVisible(true);
				      	
					}
				});
				
				
			}
		});
		
		addcoursePanel.getCancelButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				addcoursePanel.setVisible(false);
				dashboardPanel.setVisible(true);
			}
		});
		
		addcoursePanel.getOpenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser c = new JFileChooser();
				int rVal = c.showOpenDialog(GUI.this);
				if(rVal == c.APPROVE_OPTION) {
					String name = c.getSelectedFile().getName();
					String dir = c.getCurrentDirectory().toString();
					System.out.println(name + "\n" + dir);
				}
				if(rVal == c.CANCEL_OPTION){
					System.out.println("You pressed cancel");
				}
			}
		});
		
		managePage.getaddassignmentButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				managePage.setVisible(false);
				assignmentPanel.setVisible(true);
			}
		});
		
		managePage.deletestudentButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selRowIndexs=managePage.getTable().getSelectedRows();
				System.out.println(selRowIndexs.length);
				if(selRowIndexs==null||selRowIndexs.length==0) JOptionPane.showMessageDialog(managePage, "Please select student first!");
				else{
				int t=JOptionPane.showConfirmDialog(managePage,"Are you sure to delete the student?");
				if(t==0) { 
					
					 //System.out.println(selRowIndexs.length);
		            for(int i=0;i<selRowIndexs.length;i++){  
		            	//System.out.println(i+" "+selRowIndexs[i]);
		        	  managePage.getd().removeRow(selRowIndexs[i]-i);
		          }
		            JOptionPane.showMessageDialog(managePage, "Succeed!");
		            
				}
				
			}	
				}		
		});
		/*
		managePage.getdeletecolButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int[] selcolIndexs=managePage.getTable().getSelectedColumns();
				if(selcolIndexs==null||selcolIndexs.length==0) JOptionPane.showMessageDialog(managePage, "Please select column first!");
				else{
					int t=JOptionPane.showConfirmDialog(managePage,"Are you sure to delete these column?");
				if(t==0) {
					// managePage.getTable().removeColumn(managePage.getTable().getColumnModel().getColumn(selcolIndexs[0]));
            for(int i=0;i<selcolIndexs.length;i++){       	  
        	  managePage.getTable().removeColumn(managePage.getTable().getColumnModel().getColumn(selcolIndexs[i]-i));
          }
				
				}
			}}
			
		});*/
		
		managePage.getdeletecolButton().addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {    
			     int[] selcolIndexs=managePage.getTable().getSelectedColumns();
			     int c=managePage.getTable().getColumnCount();
			     int r=managePage.getTable().getRowCount();
			    if(selcolIndexs==null||selcolIndexs.length==0) JOptionPane.showMessageDialog(managePage, "Please select column first!");
			    else{
			     int t=JOptionPane.showConfirmDialog(managePage,"Are you sure to delete these column?");
			    if(t==0) {
			     // managePage.getTable().removeColumn(managePage.getTable().getColumnModel().getColumn(selcolIndexs[0]));
			           HashSet<Integer> h=new HashSet();
			           String[] n=new String[c-selcolIndexs.length]; 
			           Object[][] o=new Object[r][c-selcolIndexs.length];
			           for(int i=0;i<selcolIndexs.length;i++){
			        	   h.add(selcolIndexs[i]);
			           }
			       
			           for(int i=0,j=0;i<n.length;){
			         
			            if(!h.contains(j)) {
			             n[i]=managePage.getd().getColumnName(j);
			             i++;j++;
			             } 
			            else j++;
			            
			           }        
			           for(int w=0;w<r;w++) {
			           for(int i=0,j=0;i<n.length;){
			         
			            if(!h.contains(j)) {
			             o[w][i]=managePage.getd().getValueAt(w, j);
			             i++;j++;
			             } 
			            else j++;            
			           }
			           }
			           managePage.update(n,o);   
			    }
			   }}
			   
			  });
		
		managePage.getrowButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d = managePage.getd();
				d.addRow(new Object[] {});
			}
		});
		
		managePage.getclosecourseButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//read only
				int t=JOptionPane.showConfirmDialog(managePage,"Are you sure to close this course? If yes the data will be read-only!");
				if(t==0)
					managePage.getTable().setEnabled(false);
		
			}
		});
		
		managePage.getexitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//read only
				int t=JOptionPane.showConfirmDialog(managePage,"Are you sure to exit this chart? ");
				if(t==0) {
					managePage.setVisible(false);
					dashboardPanel.setVisible(true);}
		
			}
		});
		
		
		managePage.getdeletesheetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int t=JOptionPane.showConfirmDialog(managePage,"Are you sure to delete this whole table? ");
				if(t==0) {					
					dashboardPanel.getcoursePanel().remove(managePage.getb());
					managePage.setVisible(false);
					dashboardPanel.setVisible(true);
				}
		
			}
		});
		
		
		managePage.getUpdateAssignment().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d = managePage.getd();
				int columncount = d.getColumnCount()-2;
				String[] forCombo = new String[columncount];
				for(int i=0, j=2;i<columncount;i++, j++) {
					forCombo[i] = d.getColumnName(j);
				}
				updateAssignmentPanel.SetforCombo(forCombo);
				managePage.setVisible(false);
				updateAssignmentPanel.setVisible(true);
			}
		});
		
		managePage.getStatistic().addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    managePage.setVisible(false);
			    
			    String[] forCombo;
			     int colCount=managePage.getd().getColumnCount();
			     //System.out.println(colCount);
			      forCombo=new String[colCount-2];/////-5
			      
			      for(int i=0,j=2;j<colCount;i++,j++) {
			       forCombo[i]=managePage.getd().getColumnName(j);
			      }
			      staPanel.SetforCombo(forCombo);
			    
			      staPanel.setVisible(true);
			   }
			   
			  });
		
		managePage.getTotal().addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    DefaultTableModel tableModel = managePage.getd();
			    int rowCount=tableModel.getRowCount();
			    int colCount=tableModel.getColumnCount();
			    double[] weight=new double[] {0.2,0.8};
			    tableModel.addColumn("total");      
			    for(int i=0;i<rowCount;i++) {
			     double fenshu=0;
			    
			     for(int j=0;j<weight.length;j++) {
			          
			     //!!!!!!! 
			     int dex=2+j; ////5
			     if(tableModel.getValueAt(i, dex)!=null)
			     {
			      fenshu+=Integer.parseInt(tableModel.getValueAt(i, dex).toString())*weight[j];
			      //if(jiade){fenshu+=Integer.parseInt(tableModel.getValueAt(i, dex).toString())*weight[j];}
			     //else{fenshu+=(HW1.MAX+Integer.parseInt(tableModel.getValueAt(i, dex).toString()) )*weight[j];}
			     }                         
			    
			     }
			     //to[i]=fenshu;
			     
			     tableModel.setValueAt(fenshu, i, colCount);
			     
			     
			   }
			    
//			    Vector<Object> toda =(tableModel).getDataVector();
//			    toda.add(to);
			//    
//			    setDataVector(dataVector, columnIdentifiers);setDataVector(toda, columnNames);
			    
			   
			  }});
		/*
		managePage.getsavesheetButton().addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    DefaultTableModel m = managePage.getd();
			    int r=m.getRowCount();
			    int c=m.getColumnCount();
			    String[] colName=new String[c];
			    Object[][] tab=new Object[r][c];
			    for(int i=0;i<c;i++) {
			     colName[i]=m.getColumnName(i);
			     //System.out.println(colName[i]);
			     }    
			    for(int i=0;i<r;i++) {
			     for(int j=0;j<c;j++) {
			                    tab[i][j]=m.getValueAt(i, j);
			    }
			            
			   }
			    ///return tab, colName
			    
			    
			  }});
		*/
		
		managePage.getexitButton().addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    DefaultTableModel m = managePage.getd();
			    int r=m.getRowCount();
			    int c=m.getColumnCount();
			    String[] colName=new String[c];
			    Object[][] tab=new Object[r][c];
			    for(int i=0;i<c;i++) {
			     colName[i]=m.getColumnName(i);
			     //System.out.println(colName[i]);
			     }    
			    for(int i=0;i<r;i++) {
			     for(int j=0;j<c;j++) {
			                    tab[i][j]=m.getValueAt(i, j);
			    }
			            
			   }
			    ///return tab, colName
			    managePage.setVisible(false);
			    dashboardPanel.setVisible(true); 
			    
			  }
			   });
		
		managePage.getaddNote().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int colIndex = managePage.getTable().getSelectedColumn();
				//int rowIndex = managePage.getTable().getSelectedRow();
				int rowcount = managePage.getd().getRowCount();
				int colcount = managePage.getd().getColumnCount();
				Vector<Vector> v = managePage.getd().getDataVector();
				boolean[] s = new boolean[rowcount];
				//System.out.println(colIndex + " " + rowIndex);
				//System.out.println(rowcount + " " + rowcount);
				
//				if(colIndex == -1 || rowIndex == -1) {
//					JOptionPane.showMessageDialog(managePage, "Please select the cell first!");
//				}
//				else {
					//String note = managePage.getTa().getText();
//					if(note==null) {
//						
//					}
					String note = managePage.getTa().getText();
					//String note = JOptionPane.showInputDialog(managePage, "Note you want to add:");
					
					///// !!!!!!!!! 返回给后台
					//return note, row, column
				//}
				
				//for(int i=0;i<rowcount;i++) {
					//s[i] = managePage.getd().getColumnName(i);
				//}
				//System.out.println(s);
				Enumeration<TableColumn> kk = managePage.getTable().getColumnModel().getColumns();
				//TableCellRenderer renderer = new TableCellRenderer();
				//@Override
				
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
					//public void setValue
					public Component getTableCellRendererComponent(JTable table, Object value,
					    boolean isSelected, boolean hasFocus, int row, int column) {
						table = managePage.getTable();
						table.setFillsViewportHeight(true);
						setOpaque(true);
						Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
						for(int i=0;i<table.getRowCount();i++) {
							cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, i, i);
							cell.setBackground(Color.RED);
						}
//						Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
//						if(row==1 && column==1 && cell.isBackgroundSet()  ) {//设置变色的单元格
//							cell.setBackground(Color.RED);
//							//s[rowIndex] = true;
//						}
//						else if(row==2 && column==2 && cell.isBackgroundSet()  ) {//设置变色的单元格
//							cell.setBackground(Color.RED);
//							//s[rowIndex] = true;
//						}
//						
//						else if(cell.getBackground()!=Color.RED){
//							cell.setBackground(Color.LIGHT_GRAY);
//						}
							//cell.setBackground(Color.LIGHT_GRAY);
							//cell.setBackground(rowIndex % 2 == 0 ? getBackground() : Color.LIGHT_GRAY);
						
						return cell;
					}
				};
				
		
				for(int i = 0;i<colcount;i++) {
					managePage.getTable().getColumn(managePage.getTable().getColumnName(i)).setCellRenderer(tcr);
				}
				
			}
		});
		
		
		managePage.getSaveMenuItem().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    DefaultTableModel m = managePage.getd();
			    int r=m.getRowCount();
			    int c=m.getColumnCount();
			    String[] colName=new String[c];
			    Object[][] tab=new Object[r][c];
			    for(int i=0;i<c;i++) {
			     colName[i]=m.getColumnName(i);
			     //System.out.println(colName[i]);
			     }    
			    for(int i=0;i<r;i++) {
			     for(int j=0;j<c;j++) {
			                    tab[i][j]=m.getValueAt(i, j);
			    }
			            
			   }
			    ///return tab, colName
			    
			    
			  }
		});
		
		managePage.getdeleteMenuItem().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t=JOptionPane.showConfirmDialog(managePage,"Are you sure to delete this whole table? ");
				if(t==0) {
					dashboardPanel.getcoursePanel().remove(managePage.getb());
					managePage.setVisible(false);
					dashboardPanel.setVisible(true);
				}
			}
		});
		
		
		staPanel.getBackButton().addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    staPanel.setVisible(false);
			    managePage.setVisible(true);
			    
		}});
			 
		staPanel.getCalButton().addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {     
			    DefaultTableModel model =managePage.getd();    
			        int rowCount= model.getRowCount();       
			        String t=staPanel.getchooseHW().getSelectedItem().toString();       
			       // !!!!!!!
			        int c=staPanel.getchooseHW().getSelectedIndex()+2; //+5 default
			        double[] data=new double[rowCount];
			        for(int i=0;i<rowCount;i++){
			         if(model.getValueAt(i, c)==null)
			          data[i]=0;
			         else
			         data[i]=Double.parseDouble(model.getValueAt(i, c).toString());    
			        }
			        
			        double test=0;
			        for(int j=0;j<2;j++)
			         test+=data[j];
			        JOptionPane.showMessageDialog(staPanel,t+"'s "+test/2+"\n" + "Statistic:\nMean:\nMedian:\nStdDev:\nHighest\nLowest:\n");
			  
			   }
			   
			  });
		
		updateAssignmentPanel.getConfirmButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d = managePage.getd();
				int rowcount = d.getRowCount();
				
				
				//!!!!!!+5
				int index = updateAssignmentPanel.getchooseHwBox().getSelectedIndex() + 2;     
				//System.out.println(index);
				String weight = updateAssignmentPanel.getpercentField().getText();
				String max = updateAssignmentPanel.getmaximumField().getText();
				boolean deduct = updateAssignmentPanel.getpointBox().isSelected();
				
				updateAssignmentPanel.setVisible(false);
				managePage.setVisible(true);
				//return index, changed weight, max, deduct. 
			}
		});
		
		updateAssignmentPanel.getCancelButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAssignmentPanel.setVisible(false);
				managePage.setVisible(true);
			}
		});
		
		assignmentPanel.getConfirmButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				assignmentPanel.setVisible(false);
				// add colomn name
				
				DefaultTableModel tableModel = managePage.getd();
				boolean x = assignmentPanel.getpointBox().isSelected();
				if(x) {
					tableModel.addColumn(assignmentPanel.getassignmentField().getText() + " (Max:" + assignmentPanel.getmaximumField().getText() + "/" + assignmentPanel.getpercentField().getText() + "% " + "/'-')");
				}
				else {
					tableModel.addColumn(assignmentPanel.getassignmentField().getText() + " (Max:" + assignmentPanel.getmaximumField().getText() + "/" + assignmentPanel.getpercentField().getText() + "% " + "/'+')");
				}
				managePage.setVisible(true);
			}
		});
		
	
		
		assignmentPanel.getCancelButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				assignmentPanel.setVisible(false);
				// add colomn name
				managePage.setVisible(true);
			}
		});
		
		
		//DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		//tableModel.addRow(new Object[]{"sitinspring", "35", "Boss"});
	
		
		
		
	}	


}



