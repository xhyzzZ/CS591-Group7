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

    public Grade(int studentId, int assignmentId, int score, String note) {
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.score = score;
        this.note = note;
    }


}
