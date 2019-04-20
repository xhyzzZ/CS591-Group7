package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    public enum Type {
        SPRING, SUMMER, FALL
    }

    private int courseId;
    private int userId;
    private String courseName;
    private String year;
    private Type type;

    public Course(int userId, String courseName, String year, String type) {
        this.userId = userId;
        this.courseName = courseName;
        this.year = year;
        this.type = Type.valueOf(type);
    }
}
