package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.StudentRepositoryImpl;
import CS591.GradeManageSystem.Service.StudentService;
import CS591.GradeManageSystem.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

    @Override
    public Student createStudent(int courseId, String firstName, String middleName, String lastName, String email, int age, String type, String gender) {
        Student student = new Student(courseId, firstName, middleName, lastName, email, "", age, type, gender);
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> getStudents(int courseId) {
        return studentRepository.findByCourseId(courseId);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }
}
