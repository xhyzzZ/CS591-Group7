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
    private boolean editable;

    public Course(int userId, String courseName, String year, String type, boolean editable) {
        this.userId = userId;
        this.courseName = courseName;
        this.year = year;
        this.type = Type.valueOf(type);
        this.editable = editable;
    }
}
