package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unit {

    private int unitId;
    private int courseId;
    private int studentId;
    private int assignmentId;
    private String content;
    private String note;

    public Unit(int courseId, int studentId, int assignmentId, String content, String note) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.content = content;
        this.note = note;
    }
}
