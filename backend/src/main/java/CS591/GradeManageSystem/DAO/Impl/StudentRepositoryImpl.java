package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Grade;
import CS591.GradeManageSystem.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    public List<Student> getStudents() {
        List<Student> students=  new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = "SELECT * FROM STUDENT";
            pst = conn.prepareStatement("exec");

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()){
                Student student = new Student(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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
            String exec = String.format("INSERT INTO GRADE(studentId, firstName, middleName, lastName, email, age, note) VALUES('%d', '%s', '%s', '%s', '%s', '%d', '%s');",
                    studentId, firstName, middleName, lastName, email, age, note);
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

}
