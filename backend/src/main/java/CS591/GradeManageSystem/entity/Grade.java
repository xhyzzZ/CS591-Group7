package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {

    private int gradeId;
    private int studentId;
    private int assignmentId;
    private int score;
    private String note;

}
