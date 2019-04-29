package test;

import CS591.GradeManageSystem.DAO.Impl.StudentRepositoryImpl;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentTest {


    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    private void initialize() {

        try {
            conn = AppConf.getConnection();

            String exec = "DELETE FROM STUDENT;";

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

            Student student = new Student(1, "test1");
            studentRepository.save(student);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM STUDENT WHERE studentId = %d;", student.getStudentId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int courseId = 1;
            String note = "test1";
            while (rs.next()) {
                courseId = rs.getInt(2);
                note = rs.getString(3);
            }

            Assert.assertEquals(1, courseId);
            Assert.assertEquals("test1", note);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void update() {

        try {
            initialize();

            Student student = new Student(1, "test2");
            studentRepository.save(student);

            student.setCourseId(2);
            student.setNote("test2.1");
            studentRepository.update(student);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM STUDENT WHERE studentId = %d;", student.getStudentId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int courseId = -1;;
            String note = "";
            while (rs.next()) {
                courseId = rs.getInt(2);
                note = rs.getString(3);
            }

            Assert.assertEquals(2, courseId);
            Assert.assertEquals("test2.1", note);

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByStudentId() {
        try {
            initialize();

            Student student = new Student(1, "test3");
            studentRepository.save(student);

            Student ret = studentRepository.findByStudentId(student.getStudentId());

            Assert.assertNotNull(ret);
            Assert.assertEquals(1, ret.getCourseId());
            Assert.assertEquals("test3", ret.getNote());

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByCourseId() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec1 = "INSERT INTO STUDENT(courseId, note) VALUES(1, 'test4.1');";
            String exec2 = "INSERT INTO STUDENT(courseId, note) VALUES(1, 'test4.2');";

            pst = conn.prepareStatement(exec1);
            pst.executeUpdate();

            pst = conn.prepareStatement(exec2);
            pst.executeUpdate();

            List<Student> students = studentRepository.findByCourseId(1);
            students.sort(Comparator.comparingInt(Student::getStudentId));

            Assert.assertNotNull(students.get(0));
            Student student0 = students.get(0);
            Assert.assertEquals(1, student0.getCourseId());
            Assert.assertEquals("test4.1", student0.getNote());

            Assert.assertNotNull(students.get(1));
            Student student1 = students.get(1);
            Assert.assertEquals(1, student1.getCourseId());
            Assert.assertEquals("test4.2", student1.getNote());

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByStudentId() {
        try {
            initialize();

            Student student = new Student(1, "test5");
            studentRepository.save(student);

            studentRepository.deleteByStudentId(student.getStudentId());

            Student ret = studentRepository.findByStudentId(student.getStudentId());

            Assert.assertNull(ret);

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByCourseId() {
        try {
            initialize();

            Student student1 = new Student(1, "test6.1");
            Student student2 = new Student(1, "test6.2");
            studentRepository.save(student1);
            studentRepository.save(student2);

            studentRepository.deleteByCourseId(1);

            List<Student> ret = studentRepository.findByCourseId(1);

            Assert.assertTrue(ret.isEmpty());

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
