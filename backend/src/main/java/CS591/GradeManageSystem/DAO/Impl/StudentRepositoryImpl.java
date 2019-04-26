package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.StudentRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    @Override
    public void update(Student student) {
        try {
            conn = AppConf.getConnection();

            int studentId = student.getStudentId();
            int courseId = student.getCourseId();
            String note = student.getNote();

            // pre-process the execution
            String exec = String.format("UPDATE STUDENT SET courseId = %d, note = \'%s\' WHERE studentId = %d;",
                    courseId, note, studentId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void save(Student student) {
        try {
            conn = AppConf.getConnection();

            int courseId = student.getCourseId();
            String note = student.getNote();

            // pre-process the execution
            String exec = String.format("INSERT INTO COURSE(courseId, note) VALUES(%d, \'%s\');",
                    courseId, note);
            pst = conn.prepareStatement(exec, Statement.RETURN_GENERATED_KEYS);

            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating student failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    student.setStudentId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating student failed, no ID obtained.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByStudentId(Integer studentId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM STUDENT WHERE studentId = %d;", studentId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Student findByStudentId(Integer studentId) {
        Student student = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM STUDENT WHERE studentId = %d;", studentId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                 student = new Student(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return student;
    }

    @Override
    public List<Student> findByCourseId(Integer courseId) {
        List<Student> students = new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM STUDENT WHERE courseId = %d;", courseId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()){
                Student student = new Student(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3));
                students.add(student);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return students;
    }

    @Override
    public void deleteByCourseId(Integer courseId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM STUDENT WHERE courseId = %d", courseId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
