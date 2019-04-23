package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.StudentRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            String firstName = student.getFirstName();
            String middleName = student.getMiddleName();
            String lastName = student.getLastName();
            String email = student.getEmail();
            int age = student.getAge();
            String note = student.getNote();

            // pre-process the execution
            String exec = String.format("UPDATE GRADE(firstName, middleName, lastName, email, age, note) VALUES('%s', '%s', '%s', '%s', '%d', '%s') WHERE studentId = '%d';",
                    firstName, middleName, lastName, email, age, note, studentId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void save(Student student) {
        try {
            conn = AppConf.getConnection();

            int studentId = student.getStudentId();
            String firstName = student.getFirstName();
            String middleName = student.getMiddleName();
            String lastName = student.getLastName();
            String email = student.getEmail();
            int age = student.getAge();
            String note = student.getNote();

            // pre-process the execution
            String exec = String.format("INSERT INTO GRADE(firstName, middleName, lastName, email, age, note) VALUES('%s', '%s', '%s', '%s', '%d', '%s');",
                    firstName, middleName, lastName, email, age, note);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(Integer studentId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM STUDENT WHERE studentId = '%s'", studentId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Student findById(Integer studentId) {
        Student student = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM STUDENT WHERE studentId = '%s'", studentId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                 student = new Student(rs.getInt("studentId"),
                        rs.getInt("courseId"),
                        rs.getString("firstName"),
                        rs.getString("middleName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("note"),
                        rs.getInt("age"),
                        Student.Type.valueOf(rs.getString("type")),
                        Student.Gender.valueOf(rs.getString("gender")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return student;
    }

    @Override
    public List<Student> findByCourseId(Integer courseId) {
        List<Student> students=  new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM STUDENT WHERE courseId = %d", courseId);
            pst = conn.prepareStatement("exec");

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()){
                Student student = new Student(rs.getInt("studentId"),
                        rs.getInt("courseId"),
                        rs.getString("firstName"),
                        rs.getString("middleName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("note"),
                        rs.getInt("age"),
                        Student.Type.valueOf(rs.getString("type")),
                        Student.Gender.valueOf(rs.getString("gender")));
                students.add(student);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return students;
    }

    @Override
    public void deleteByCourseId(Integer courseId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM STUDENT WHERE courseId = '%s'", courseId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
