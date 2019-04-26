package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.StudentRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.UnitRepositoryImpl;
import CS591.GradeManageSystem.Service.StudentService;
import CS591.GradeManageSystem.entity.Student;

import java.util.Comparator;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    private UnitRepositoryImpl unitRepository = new UnitRepositoryImpl();

    @Override
    public Student createStudent(int courseId, String note) {
        Student student = new Student(courseId, note);
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> getStudents(int courseId) {
        List<Student> students = studentRepository.findByCourseId(courseId);
        students.sort(Comparator.comparingInt(Student::getStudentId));
        return students;
    }

    @Override
    public void deleteStudent(int studentId) {
        unitRepository.deleteByStudentId(studentId);
        studentRepository.deleteByStudentId(studentId);
    }
}
