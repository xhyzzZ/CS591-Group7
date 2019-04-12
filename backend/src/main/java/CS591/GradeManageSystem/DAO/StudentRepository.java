package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Student;
import java.util.List;

public interface StudentRepository {
    List<Student> getStudents();

    void save(Student student);

    void deleteById(Integer id);

    Student findById(Integer id);
}
