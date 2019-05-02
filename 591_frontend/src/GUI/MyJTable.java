package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

class MyJTable extends JTable implements MouseListener{
	//MyJTable table;
	int r;
	int c;
	
	MyJTable() {
		super();
		this.addMouseListener(this);
	}
	
	MyJTable(DefaultTableModel d){
		super(d);
		this.addMouseListener(this);
		
	}
	
	public void mouseClicked(MouseEvent evt) {
		r = this.rowAtPoint(evt.getPoint());
		c = this.columnAtPoint(evt.getPoint());
		if(true) {//(student) r, (hw) c.hasNote
			//String note = ;
			System.out.println(r + " " + c);
			ManagementInterface.ta.setText(r + " " + c);
		}
		else {
			ManagementInterface.ta.setText(" ");
		}
	}
	
//	public Component prepareRenderer(TableCellRenderer renderer, int row,
//            int column) {
//			int r = this.getSelectedRow();
//			int c = this.getSelectedColumn();
//			Component component = super.prepareRenderer(renderer, row, column);
//
//			if (row == r && column == c) {
//				component.setBackground(Color.RED);
//			}
//
//			return component;
//	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
