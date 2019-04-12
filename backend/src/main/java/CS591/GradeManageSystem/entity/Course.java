package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private enum Type {
        SPRING, SUMMER, FALL
    }

    private int courseId;
    private int userId;
    private String courseName;
    private String year;
    private Type type;
}
