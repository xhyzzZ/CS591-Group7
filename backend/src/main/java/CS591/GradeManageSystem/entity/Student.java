package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int studentId;
    private int courseId;
    private String note;

    public Student(int courseId, String note) {
        this.courseId = courseId;
        this.note = note;
    }

}
