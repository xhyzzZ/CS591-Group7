package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Student;
import java.util.List;

public interface StudentService {

    Student createStudent(int courseId, String note);

    List<Student> getStudents(int courseId);

    void deleteStudent(int studentId);
}
