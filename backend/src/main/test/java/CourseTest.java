import CS591.GradeManageSystem.DAO.Impl.CourseRepositoryImpl;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Course;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseTest {


    private CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    private void initialize() {

        try {
            conn = AppConf.getConnection();

            String exec = "DELETE FROM COURSE;";

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

            Course course = new Course(1, "test1", "2019", "SPRING", true);
            courseRepository.save(course);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM COURSE WHERE courseId = %d;", course.getCourseId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int userId = -1;
            String courseName = "";
            String year = "";
            String type = "";
            boolean editable = false;
            while (rs.next()) {
                userId = rs.getInt(2);
                courseName = rs.getString(3);
                year = rs.getString(4);
                type = rs.getString(5);
                editable = rs.getBoolean(6);
            }

            Assert.assertEquals(1, userId);
            Assert.assertEquals("test1", courseName);
            Assert.assertEquals("2019", year);
            Assert.assertEquals("SPRING", type);
            Assert.assertTrue(editable);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void update() {

        try {
            initialize();

            Course course = new Course(1, "test2", "2019", "SPRING", true);
            courseRepository.save(course);

            course.setUserId(2);
            course.setCourseName("test2.1");
            course.setYear("2020");
            course.setType(Course.Type.valueOf("SUMMER"));
            course.setEditable(false);
            courseRepository.update(course);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM COURSE WHERE courseId = %d;", course.getCourseId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int userId = -1;
            String courseName = "";
            String year = "";
            String type = "";
            boolean editable = true;
            while (rs.next()) {
                userId = rs.getInt(2);
                courseName = rs.getString(3);
                year = rs.getString(4);
                type = rs.getString(5);
                editable = rs.getBoolean(6);
            }

            Assert.assertEquals(2, userId);
            Assert.assertEquals("test2.1", courseName);
            Assert.assertEquals("2020", year);
            Assert.assertEquals("SUMMER", type);
            Assert.assertFalse(editable);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByCourseId() {
        try {
            initialize();

            Course course = new Course(1, "test3", "2019", "SPRING", true);
            courseRepository.save(course);

            Course ret = courseRepository.findByCourseId(course.getCourseId());

            Assert.assertNotNull(ret);
            Assert.assertEquals(1, ret.getUserId());
            Assert.assertEquals("test3", ret.getCourseName());
            Assert.assertEquals("2019", ret.getYear());
            Assert.assertEquals("SPRING", ret.getType().toString());
            Assert.assertTrue(ret.isEditable());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByCourseName() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec1 = "INSERT INTO COURSE(userId, courseName, year, type, editable) VALUES(1, 'test4', '2019', 'SPRING', FALSE);";
            String exec2 = "INSERT INTO COURSE(userId, courseName, year, type, editable) VALUES(2, 'test4', '2020', 'FALL', TRUE);";

            pst = conn.prepareStatement(exec1);
            pst.executeUpdate();

            pst = conn.prepareStatement(exec2);
            pst.executeUpdate();

            List<Course> course = courseRepository.findByCourseName("test4");
            course.sort(Comparator.comparingInt(Course::getCourseId));

            Assert.assertNotNull(course.get(0));
            Course course0 = course.get(0);
            Assert.assertEquals(1, course0.getUserId());
            Assert.assertEquals("test4", course0.getCourseName());
            Assert.assertEquals("2019", course0.getYear());
            Assert.assertEquals("SPRING", course0.getType().toString());
            Assert.assertFalse(course0.isEditable());

            Assert.assertNotNull(course.get(1));
            Course course1 = course.get(1);
            Assert.assertEquals(2, course1.getUserId());
            Assert.assertEquals("test4", course1.getCourseName());
            Assert.assertEquals("2020", course1.getYear());
            Assert.assertEquals("FALL", course1.getType().toString());
            Assert.assertTrue(course1.isEditable());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByUserId() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec1 = "INSERT INTO COURSE(userId, courseName, year, type, editable) VALUES(1, 'test5.1', '2019', 'SPRING', FALSE);";
            String exec2 = "INSERT INTO COURSE(userId, courseName, year, type, editable) VALUES(1, 'test5.2', '2020', 'FALL', TRUE);";

            pst = conn.prepareStatement(exec1);
            pst.executeUpdate();

            pst = conn.prepareStatement(exec2);
            pst.executeUpdate();

            List<Course> course = courseRepository.findByUserId(1);
            course.sort(Comparator.comparingInt(Course::getCourseId));

            Assert.assertNotNull(course.get(0));
            Course course0 = course.get(0);
            Assert.assertEquals(1, course0.getUserId());
            Assert.assertEquals("test5.1", course0.getCourseName());
            Assert.assertEquals("2019", course0.getYear());
            Assert.assertEquals("SPRING", course0.getType().toString());
            Assert.assertFalse(course0.isEditable());

            Assert.assertNotNull(course.get(1));
            Course course1 = course.get(1);
            Assert.assertEquals(1, course1.getUserId());
            Assert.assertEquals("test5.2", course1.getCourseName());
            Assert.assertEquals("2020", course1.getYear());
            Assert.assertEquals("FALL", course1.getType().toString());
            Assert.assertTrue(course1.isEditable());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByCourseId() {
        try {
            initialize();

            Course course = new Course(1, "test6", "2019", "SPRING", true);
            courseRepository.save(course);

            courseRepository.deleteByCourseId(course.getCourseId());

            Course ret = courseRepository.findByCourseId(course.getCourseId());

            Assert.assertNull(ret);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
