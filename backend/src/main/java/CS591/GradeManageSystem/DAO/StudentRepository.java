package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Student;
import java.util.List;

public interface StudentRepository {

    // courseId studentId note

    void save(Student studentId);

    void deleteByStudentId(Integer studentId);

    void update(Student student);

    Student findByStudentId(Integer studentId);

    List<Student> findByCourseId(Integer courseId);

    void deleteByCourseId(Integer courseId);
}
