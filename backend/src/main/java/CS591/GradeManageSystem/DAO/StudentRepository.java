package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Student;
import java.util.List;

public interface StudentRepository {

    // studentId   firstName    middleName    lastName   email   gender  age     grad/under   note
    List<Student> getStudents();

    void save(Student studentId);

    void deleteById(Integer studentId);

    void update(Student student);

    Student findById(Integer studentId);

    Student findByNote(Integer studentId);



}
