package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    private int assignmentId;
    private int courseId;
    private String assignmentName;
    private int weight;
    private boolean addPoint;
    private boolean extraBonus;
    private boolean fix;

    public Assignment(int courseId, String assignmentName, int weight, boolean addPoint, boolean extraBonus, boolean fix) {
        this.courseId = courseId;
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.addPoint = addPoint;
        this.extraBonus = extraBonus;
        this.fix = fix;
    }
}
