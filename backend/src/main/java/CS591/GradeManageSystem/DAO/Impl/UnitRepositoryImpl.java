package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.UnitRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Unit;
import CS591.GradeManageSystem.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitRepositoryImpl implements UnitRepository {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    @Override
    public void update(Unit unit) {
        try {
            conn = AppConf.getConnection();
            int unitId = unit.getUnitId();
            int courseId = unit.getCourseId();
            int studentId = unit.getStudentId();
            int assignmentId = unit.getAssignmentId();
            String content = unit.getContent();
            String note = unit.getNote();

            // pre-process the execution
            String exec = String.format("UPDATE UNIT SET courseId = %d, studentId = %d , assignmentId = %d, content = \'%s\', note = \'%s\' WHERE unitId = %d;",
                    courseId, studentId, assignmentId, content, note, unitId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void save(Unit unit) {
        try {
            conn = AppConf.getConnection();

            int courseId = unit.getCourseId();
            int studentId = unit.getStudentId();
            int assignmentId = unit.getAssignmentId();
            String content = unit.getContent();
            String note = unit.getNote();

            // pre-process the execution
            String exec = String.format("INSERT INTO UNIT(courseId, studentId, assignmentId, content, note) VALUES(%d, %d, %d, \'%s\', \'%s\');",
                    courseId, studentId, assignmentId, content, note);
            pst = conn.prepareStatement(exec, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException(Constants.UNITFAILEDONROWS);
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    unit.setUnitId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException(Constants.UNITFAILEDONID);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByUnitId(Integer unitId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM UNIT WHERE unitId = %d;", unitId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByCourseIdAndStudentId(Integer courseId, Integer studentId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM UNIT WHERE courseId = %d AND studentId = %d;", courseId, studentId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByCourseIdAndAssignmentId(Integer courseId, Integer assignmentId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM UNIT WHERE courseId = %d AND assignmentId = %d;", courseId, assignmentId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByCourseId(Integer courseId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM UNIT WHERE courseId = %d;", courseId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Unit findByUnitId(Integer unitId) {
        Unit unit = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM UNIT WHERE unitId = %d;", unitId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                unit = new Unit(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return unit;
    }

    @Override
    public List<Unit> findByCourseId(Integer courseId) {
        List<Unit> units = new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM UNIT WHERE courseId = %d;", courseId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                Unit unit = new Unit(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
                units.add(unit);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return units;
    }

    @Override
    public Unit findByAssignmentIdAndStudentId(Integer assignmentId, Integer studentId) {
        Unit unit = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM UNIT WHERE assignmentId = %d AND studentId = %d;", assignmentId, studentId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                unit = new Unit(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return unit;
    }
}
