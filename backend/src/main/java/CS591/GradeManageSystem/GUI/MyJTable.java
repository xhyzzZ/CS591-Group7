package CS591.GradeManageSystem.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

class MyJTable extends JTable implements MouseListener {

    private static int r;
    private static int c;
    private String note;

    MyJTable() {
        super();
        this.addMouseListener(this);
        this.getTableHeader().addMouseListener(new TableHeaderMouseListener(this));
    }

    MyJTable(DefaultTableModel d) {
        super(d);
        this.addMouseListener(this);
        this.getTableHeader().addMouseListener(new TableHeaderMouseListener(this));
    }

    public void mouseClicked(MouseEvent evt) {
        int r = this.rowAtPoint(evt.getPoint());
        int c = this.columnAtPoint(evt.getPoint());
        ManagementInterface.ta.setText(GUI.getNote(r, c));
    }

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
