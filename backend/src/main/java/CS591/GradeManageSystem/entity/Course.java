package CS591.GradeManageSystem.entity;

import java.util.List;

import CS591.GradeManageSystem.entity.Column.Column;
import CS591.GradeManageSystem.entity.Student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String courseName;

    private String userId;

    private List<String> students;

    private int year;

    private enum season {
        SPRING, SUMMER, FALL
    }

    private Map<Column, Map<Student, Grade>> columns;
}
