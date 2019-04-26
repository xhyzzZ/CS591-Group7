package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.AssignmentRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Assignment;

import java.sql.*;
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
            String exec = String.format("SELECT * FROM ASSIGNMENT WHERE courseId = %d;", courseId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            rs = pst.executeQuery();
            while (rs.next()) {
                Assignment assignment = new Assignment(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7));

                assignments.add(assignment);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return assignments;
    }

    @Override
    public Assignment findByAssignmentId(int assignmentId) {
        Assignment assignment = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM ASSIGNMENT WHERE assignmentId = %d;", assignmentId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            rs = pst.executeQuery();
            while (rs.next()) {
                assignment = new Assignment(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return assignment;
    }

    @Override
    public void save(Assignment assignment) {
        try {
            conn = AppConf.getConnection();

            int courseId = assignment.getCourseId();
            String assignmentName = assignment.getAssignmentName();
            int weight = assignment.getWeight();
            boolean addPoint = assignment.isAddPoint();
            boolean extraBonus = assignment.isExtraBonus();
            boolean fix = assignment.isFix();

            // pre-process the execution
            String exec = String.format("INSERT INTO ASSIGNMENT(courseId, assignmentName, weight, addPoint, extraBonus, fix) VALUES(%d, \'%s\', %d, %b, %b, %b);",
                    courseId, assignmentName, weight, addPoint, extraBonus, fix);
            pst = conn.prepareStatement(exec, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating assignment failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    assignment.setAssignmentId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating assignment failed, no ID obtained.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
            boolean extraBonus = assignment.isExtraBonus();
            boolean fix = assignment.isFix();

            // pre-process the execution
            String exec = String.format("UPDATE ASSIGNMENT SET courseId = %d, assignmentName = \'%s\', weight = %d, addPoint = %b, extraBonus = %b, fix = %b) WHERE assignmentId = %d;",
                    courseId, assignmentName, weight, addPoint, extraBonus, fix, assignmentId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByAssignmentId(int assignmentId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM ASSIGNMENT WHERE assignmentId = %d;", assignmentId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByCourseId(int courseId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM ASSIGNMENT WHERE courseId = %d;", courseId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
