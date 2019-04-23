package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.AssignmentRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssignmentRepositoryImpl implements AssignmentRepository {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    @Override
    public List<Assignment> findByCourseId(int courseId) {
        List<Assignment> assignments = new ArrayList<>();

        try {
             conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM ASSIGNMENT WHERE courseId = %s", courseId);
            pst = conn.prepareStatement("exec");

            // execute the operation
            rs = pst.executeQuery();
            while (rs.next()) {
                Assignment assignment = new Assignment(rs.getInt("assignmentId"),
                        rs.getInt("courseId"),
                        rs.getString("assignmentName"),
                        rs.getInt("weight"),
                        rs.getBoolean("addPoint"),
                        rs.getBoolean("extraBonus"));

                assignments.add(assignment);
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

        return assignments;
    }

    @Override
    public void save(Assignment assignment) {
        try {
            conn = AppConf.getConnection();

            int assignmentId = assignment.getAssignmentId();
            int courseId = assignment.getCourseId();
            String assignmentName = assignment.getAssignmentName();
            int weight = assignment.getWeight();
            boolean addPoint = assignment.isAddPoint();
            boolean extraBonus =assignment.isExtraBonus();

            // pre-process the execution
            String exec = String.format("INSERT INTO ASSIGNMENT(assignmentId, courseId, assignmentName, weight, addPoint, extraBonus) VALUES('%d', '%d', '%s', '%d', '%b', '%b');",
                    assignmentId, courseId, assignmentName, weight, addPoint, extraBonus);
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
    public void update(Assignment assignment) {
        try {
            conn = AppConf.getConnection();

            int assignmentId = assignment.getAssignmentId();
            int courseId = assignment.getCourseId();
            String assignmentName = assignment.getAssignmentName();
            int weight = assignment.getWeight();
            boolean addPoint = assignment.isAddPoint();
            boolean extraBonus =assignment.isExtraBonus();

            // pre-process the execution
            String exec = String.format("UPDATE ASSIGNMENT(courseId, assignmentName, weight, addPoint, extraBonus) VALUES('%d', '%s', '%d', '%b', '%b') WHERE assignmentId = '%d';",
                    courseId, assignmentName, weight, addPoint, extraBonus, assignmentId);
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
    public void deleteByAssignmentId(int assignmentId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM ASSIGNMENT WHERE assignmentId = '%d';", assignmentId);
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
