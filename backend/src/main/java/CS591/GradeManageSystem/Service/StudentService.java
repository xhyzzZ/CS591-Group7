package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Student;
import java.util.List;

public interface StudentService {

    Student createStudent(int courseId, String firstName, String middleName, String lastName,
                       String email, int age, String type, String gender);

    List<Student> getStudents(int courseId);

    void deleteStudent(int studentId);
}
