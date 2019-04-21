package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    private int assignmentID;
    private int courseId;
    private String assignmentName;
    private int weight;
    private boolean addPoint;
    private boolean extraBonus;
}
