package test;

import CS591.GradeManageSystem.DAO.Impl.UnitRepositoryImpl;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Unit;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UnitTest {

    private UnitRepositoryImpl unitRepository = new UnitRepositoryImpl();

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    private void initialize() {

        try {
            conn = AppConf.getConnection();

            String exec = "DELETE FROM UNIT;";

            pst = conn.prepareStatement(exec);

            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void save() {

        try {
            initialize();

            Unit unit = new Unit(1, 20, 4, "40", "test1");
            unitRepository.save(unit);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM UNIT WHERE unitId = %d;", unit.getUnitId());
            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int courseId = -1;
            int studentId = -1;
            int assignmentId = -1;
            String content = "";
            String note = "";
            while (rs.next()) {
                courseId = rs.getInt(2);
                studentId = rs.getInt(3);
                assignmentId = rs.getInt(4);
                content = rs.getString(5);
                note = rs.getString(6);
            }

            Assert.assertEquals(1, courseId);
            Assert.assertEquals(20, studentId);
            Assert.assertEquals(4, assignmentId);
            Assert.assertEquals("40", content);
            Assert.assertEquals("test1", note);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void update() {

        try {
            initialize();

            Unit unit = new Unit(1, 20, 4, "40", "test2");
            unitRepository.save(unit);

            unit.setCourseId(2);
            unit.setStudentId(21);
            unit.setAssignmentId(5);
            unit.setContent("50");
            unit.setNote("test2.1");
            unitRepository.update(unit);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM UNIT WHERE unitId = %d;", unit.getUnitId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int courseId = -1;
            int studentId = -1;
            int assignmentId = -1;
            String content = "";
            String note = "";
            while (rs.next()) {
                courseId = rs.getInt(2);
                studentId = rs.getInt(3);
                assignmentId = rs.getInt(4);
                content = rs.getString(5);
                note = rs.getString(6);
            }

            Assert.assertEquals(2, courseId);
            Assert.assertEquals(21, studentId);
            Assert.assertEquals(5, assignmentId);
            Assert.assertEquals("50", content);
            Assert.assertEquals("test2.1", note);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByUnitId() {
        try {
            initialize();

            Unit unit = new Unit(1, 20, 4, "40", "test3");
            unitRepository.save(unit);

            Unit ret = unitRepository.findByUnitId(unit.getUnitId());

            Assert.assertNotNull(ret);
            Assert.assertEquals(1, ret.getCourseId());
            Assert.assertEquals(20, ret.getStudentId());
            Assert.assertEquals(4, ret.getAssignmentId());
            Assert.assertEquals("40", ret.getContent());
            Assert.assertEquals("test3", ret.getNote());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByCourseId() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec1 = "INSERT INTO UNIT(courseId, studentId, assignmentId, content, note) VALUES(1, 20, 4, '40', 'test4.1');";
            String exec2 = "INSERT INTO UNIT(courseId, studentId, assignmentId, content, note) VALUES(1, 30, 5, '50', 'test4.2');";

            pst = conn.prepareStatement(exec1);
            pst.executeUpdate();

            pst = conn.prepareStatement(exec2);
            pst.executeUpdate();

            List<Unit> units = unitRepository.findByCourseId(1);
            units.sort(Comparator.comparingInt(Unit::getUnitId));

            Assert.assertNotNull(units.get(0));
            Unit unit0 = units.get(0);
            Assert.assertEquals(1, unit0.getCourseId());
            Assert.assertEquals(20, unit0.getStudentId());
            Assert.assertEquals(4, unit0.getAssignmentId());
            Assert.assertEquals("40", unit0.getContent());
            Assert.assertEquals("test4.1", unit0.getNote());

            Assert.assertNotNull(units.get(1));
            Unit unit1 = units.get(1);
            Assert.assertEquals(1, unit1.getCourseId());
            Assert.assertEquals(30, unit1.getStudentId());
            Assert.assertEquals(5, unit1.getAssignmentId());
            Assert.assertEquals("50", unit1.getContent());
            Assert.assertEquals("test4.2", unit1.getNote());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByAssignmentIdAndStudentId() {
        try {
            initialize();

            Unit unit = new Unit(1, 20, 4, "40", "test5");
            unitRepository.save(unit);

            Unit ret = unitRepository.findByAssignmentIdAndStudentId(4, 20);

            Assert.assertNotNull(ret);
            Assert.assertEquals(1, ret.getCourseId());
            Assert.assertEquals(20, ret.getStudentId());
            Assert.assertEquals(4, ret.getAssignmentId());
            Assert.assertEquals("40", ret.getContent());
            Assert.assertEquals("test5", ret.getNote());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByUnitId() {
        try {
            initialize();

            Unit unit = new Unit(1, 20, 4, "40", "test6");
            unitRepository.save(unit);

            unitRepository.deleteByUnitId(unit.getUnitId());

            Unit ret = unitRepository.findByUnitId(unit.getUnitId());

            Assert.assertNull(ret);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByCourseId() {
        try {
            initialize();

            Unit unit1 = new Unit(1, 20, 4, "40", "test7.1");
            Unit unit2 = new Unit(1, 30, 5, "50", "test7.2");
            unitRepository.save(unit1);
            unitRepository.save(unit2);

            unitRepository.deleteByCourseId(1);

            List<Unit> ret = unitRepository.findByCourseId(1);

            Assert.assertTrue(ret.isEmpty());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByCourseIdAndStudentId() {
        try {
            initialize();

            Unit unit1 = new Unit(1, 20, 4, "40", "test7.1");
            Unit unit2 = new Unit(2, 20, 5, "50", "test7.2");
            unitRepository.save(unit1);
            unitRepository.save(unit2);

            unitRepository.deleteByCourseIdAndStudentId(1,20);

            Unit ret1 = unitRepository.findByUnitId(unit1.getUnitId());
            Unit ret2 = unitRepository.findByUnitId(unit2.getUnitId());

            Assert.assertNull(ret1);
            Assert.assertNotNull(ret2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByCourseIdAndAssignmentId() {
        try {
            initialize();

            Unit unit1 = new Unit(1, 20, 4, "40", "test7.1");
            Unit unit2 = new Unit(2, 30, 4, "50", "test7.2");
            unitRepository.save(unit1);
            unitRepository.save(unit2);

            unitRepository.deleteByCourseIdAndAssignmentId(1, 4);

            Unit ret1 = unitRepository.findByUnitId(unit1.getUnitId());
            Unit ret2 = unitRepository.findByUnitId(unit2.getUnitId());

            Assert.assertNull(ret1);
            Assert.assertNotNull(ret2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
