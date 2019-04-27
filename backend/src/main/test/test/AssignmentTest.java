package test;

import CS591.GradeManageSystem.DAO.Impl.AssignmentRepositoryImpl;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Assignment;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AssignmentTest {


    private AssignmentRepositoryImpl assignmentRepository = new AssignmentRepositoryImpl();

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    private void initialize() {

        try {
            conn = AppConf.getConnection();

            String exec = "DELETE FROM ASSIGNMENT;";

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

            Assignment assignment = new Assignment(1, "test1", 20, true, true, false);
            assignmentRepository.save(assignment);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM ASSIGNMENT WHERE assignmentId = %d;", assignment.getAssignmentId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int courseId = 1;
            String assignmentName = "";
            int weight = -1;
            boolean addPoint = false;
            boolean extraBonus = false;
            boolean fix = true;
            while (rs.next()) {
                courseId = rs.getInt(2);
                assignmentName = rs.getString(3);
                weight = rs.getInt(4);
                addPoint = rs.getBoolean(5);
                extraBonus = rs.getBoolean(6);
                fix = rs.getBoolean(7);
            }

            Assert.assertEquals(1, courseId);
            Assert.assertEquals("test1", assignmentName);
            Assert.assertEquals(20, weight);
            Assert.assertTrue(addPoint);
            Assert.assertTrue(extraBonus);
            Assert.assertFalse(fix);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void update() {

        try {
            initialize();

            Assignment assignment = new Assignment(1, "test2", 20, true, true, false);
            assignmentRepository.save(assignment);

            assignment.setCourseId(2);
            assignment.setAssignmentName("test2.1");
            assignment.setWeight(40);
            assignment.setAddPoint(false);
            assignment.setExtraBonus(false);
            assignment.setFix(true);
            assignmentRepository.update(assignment);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM ASSIGNMENT WHERE assignmentId = %d;", assignment.getAssignmentId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int courseId = -1;
            String assignmentName = "";
            int weight = -1;
            boolean addPoint = true;
            boolean extraBonus = true;
            boolean fix = false;
            while (rs.next()) {
                courseId = rs.getInt(2);
                assignmentName = rs.getString(3);
                weight = rs.getInt(4);
                addPoint = rs.getBoolean(5);
                extraBonus = rs.getBoolean(6);
                fix = rs.getBoolean(7);
            }

            Assert.assertEquals(2, courseId);
            Assert.assertEquals("test2.1", assignmentName);
            Assert.assertEquals(40, weight);
            Assert.assertFalse(addPoint);
            Assert.assertFalse(extraBonus);
            Assert.assertTrue(fix);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByAssignmentId() {
        try {
            initialize();

            Assignment assignment = new Assignment(1, "test3", 20, true, true, false);
            assignmentRepository.save(assignment);

            Assignment ret = assignmentRepository.findByAssignmentId(assignment.getAssignmentId());

            Assert.assertNotNull(ret);
            Assert.assertEquals(1, ret.getCourseId());
            Assert.assertEquals("test3", ret.getAssignmentName());
            Assert.assertEquals(20, ret.getWeight());
            Assert.assertTrue(assignment.isAddPoint());
            Assert.assertTrue(assignment.isExtraBonus());
            Assert.assertFalse(assignment.isFix());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByCourseId() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec1 = "INSERT INTO ASSIGNMENT(courseId, assignmentName, weight, addPoint, extraBonus, fix) VALUES(1, 'test4.1', 20, TRUE, TRUE, FALSE);";
            String exec2 = "INSERT INTO ASSIGNMENT(courseId, assignmentName, weight, addPoint, extraBonus, fix) VALUES(1, 'test4.2', 30, FALSE, FALSE, TRUE);";

            pst = conn.prepareStatement(exec1);
            pst.executeUpdate();

            pst = conn.prepareStatement(exec2);
            pst.executeUpdate();

            List<Assignment> assignments = assignmentRepository.findByCourseId(1);
            assignments.sort(Comparator.comparingInt(Assignment::getAssignmentId));

            Assert.assertNotNull(assignments.get(0));
            Assignment assignment0 = assignments.get(0);
            Assert.assertEquals(1, assignment0.getCourseId());
            Assert.assertEquals("test4.1", assignment0.getAssignmentName());
            Assert.assertEquals(20, assignment0.getWeight());
            Assert.assertTrue(assignment0.isAddPoint());
            Assert.assertTrue(assignment0.isExtraBonus());
            Assert.assertFalse(assignment0.isFix());

            Assert.assertNotNull(assignments.get(1));
            Assignment assignment1 = assignments.get(1);
            Assert.assertEquals(1, assignment1.getCourseId());
            Assert.assertEquals("test4.2", assignment1.getAssignmentName());
            Assert.assertEquals(30, assignment1.getWeight());
            Assert.assertFalse(assignment1.isAddPoint());
            Assert.assertFalse(assignment1.isExtraBonus());
            Assert.assertTrue(assignment1.isFix());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByAssignmentId() {
        try {
            initialize();

            Assignment assignment = new Assignment(1, "test5", 20, true, true, false);
            assignmentRepository.save(assignment);

            assignmentRepository.deleteByAssignmentId(assignment.getAssignmentId());

            Assignment ret = assignmentRepository.findByAssignmentId(assignment.getAssignmentId());

            Assert.assertNull(ret);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByCourseId() {
        try {
            initialize();

            Assignment assignment1 = new Assignment(1, "test6.1", 20, true, true, false);
            Assignment assignment2 = new Assignment(1, "test6.2", 20, true, true, false);
            assignmentRepository.save(assignment1);
            assignmentRepository.save(assignment2);

            assignmentRepository.deleteByCourseId(1);

            List<Assignment> ret = assignmentRepository.findByCourseId(1);

            Assert.assertTrue(ret.isEmpty());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
