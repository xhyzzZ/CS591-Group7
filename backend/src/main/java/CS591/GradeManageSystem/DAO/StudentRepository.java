package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Student;
import java.util.List;

public interface StudentRepository {

    // studentId   firstName    middleName    lastName   email   gender  age     grad/under   note

    void save(Student studentId);

    void deleteById(Integer studentId);

    void update(Student student);

    Student findById(Integer studentId);

    List<Student> findByCourseId(Integer courseId);

    void deleteByCourseId(Integer courseId);
}
