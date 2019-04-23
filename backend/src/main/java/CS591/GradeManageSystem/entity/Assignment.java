package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

<<<<<<< HEAD
    private int assignmentID;
=======
    private int assignmentId;
>>>>>>> 204cddb9ac9a803d2d7ff01e87bbc4d7ab8c82f1
    private int courseId;
    private String assignmentName;
    private int weight;
    private boolean addPoint;
    private boolean extraBonus;
}
