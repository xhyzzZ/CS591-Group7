package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeRepositoryImpl {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    public List<Grade> getGrades() {
        List<Grade> grades=  new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = "SELECT * FROM GRADE";
            pst = conn.prepareStatement("exec");

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()){
                Grade grade = new Grade(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3), rs.getString(4));
                grades.add(grade);
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

        return grades;
    }

    public void save(Grade grade) {
        try {
            conn = AppConf.getConnection();

            int studentId = grade.getStudentId();
            int assignmentId = grade.getAssignmentId();
            int score = grade.getScore();
            String note = grade.getNote();

            // pre-process the execution
            String exec = String.format("INSERT INTO GRADE(studentId, assignmentId, score, note) VALUES('%d', '%d', '%d', '%s');",
                    studentId, assignmentId, score, note);
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
