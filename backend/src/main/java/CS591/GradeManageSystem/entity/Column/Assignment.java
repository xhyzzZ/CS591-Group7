package CS591.GradeManageSystem.entity.Column;

import CS591.GradeManageSystem.entity.Column.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment extends Column {

    private String columnName;

    private String columnId;

    private int assignmentWeight;

    private boolean addPoints;
}
