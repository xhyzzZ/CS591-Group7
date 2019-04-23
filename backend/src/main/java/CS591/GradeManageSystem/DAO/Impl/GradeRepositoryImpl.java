package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.GradeRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeRepositoryImpl implements GradeRepository {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    @Override
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
                Grade grade = new Grade(rs.getInt("gradeId"), rs.getInt("studentId"),
                        rs.getInt("assignmentId"),
                        rs.getInt("score"), rs.getString("note"));
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

    @Override
    public void update(Grade grade) {
        try {
            conn = AppConf.getConnection();
            int gradeId = grade.getGradeId();
            int studentId = grade.getStudentId();
            int assignmentId = grade.getAssignmentId();
            int score = grade.getScore();
            String note = grade.getNote();

            // pre-process the execution
            String exec = String.format("UPDATE GRADE(studentId, assignmentId, score, note) VALUES('%d', '%d', '%d', '%s') WHERE gradeId = '%d';",
                    studentId, assignmentId, score, note, gradeId);
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
    public void save(Grade grade) {
        try {
            conn = AppConf.getConnection();

            int gradeId = grade.getGradeId();
            int studentId = grade.getStudentId();
            int assignmentId = grade.getAssignmentId();
            int score = grade.getScore();
            String note = grade.getNote();

            // pre-process the execution
            String exec = String.format("INSERT INTO GRADE(gradeId, studentId, assignmentId, score, note) VALUES('%d', '%d', '%d', '%d', '%s');",
                    gradeId, studentId, assignmentId, score, note);
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
    public void deleteById(Integer gradeId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM GRADE WHERE id = %s;", gradeId);
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
    public Grade findById(Integer gradeId) {
        Grade grade = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM GRADE WHERE gradeId = '%s'", gradeId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                grade = new Grade(rs.getInt("gradeId"), rs.getInt("studentId"),
                    rs.getInt("assignmentId"),
                    rs.getInt("score"), rs.getString("note"));
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

        return grade;
    }

    @Override
    public Grade findByStudent(Integer studentId) {
        Grade grade = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM GRADE WHERE studentId = '%s'", studentId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                grade = new Grade(rs.getInt("gradeId"), rs.getInt("studentId"),
                    rs.getInt("assignmentId"),
                    rs.getInt("score"), rs.getString("note"));
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

        return grade;
    }

    @Override
    public Grade findByAssignment(Integer assignmentId) {
        Grade grade = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM GRADE WHERE assignmentId = '%s'", assignmentId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                grade = new Grade(rs.getInt("gradeId"), rs.getInt("studentId"),
                    rs.getInt("assignmentId"),
                    rs.getInt("score"), rs.getString("note"));
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

        return grade;
    }

    @Override
    public Grade findBySingleScore(Integer gradeId, Integer studentId, Integer assignmentId) {
        return null;
    }

    @Override
    public Grade findByTotalScore(Integer gradeId, Integer assignmentId) {
        return null;
    }

    @Override
    public Grade findByNote(Integer gradeId) {
        return null;
    }

}
