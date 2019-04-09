package CS591.GradeManageSystem.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraduateStudent extends Student{

    private String studentId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private Student.type type;
}
