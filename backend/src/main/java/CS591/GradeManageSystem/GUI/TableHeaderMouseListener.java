package CS591.GradeManageSystem.GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableHeaderMouseListener extends MouseAdapter {

    private MyJTable myJTable;

    public TableHeaderMouseListener(MyJTable myJTable) {
        this.myJTable = myJTable;
    }

    public void mouseClicked(MouseEvent event) {
         Point point = event.getPoint();
         int column = myJTable.columnAtPoint(point);
         GUI.sortByColumn(column);
    }
}
