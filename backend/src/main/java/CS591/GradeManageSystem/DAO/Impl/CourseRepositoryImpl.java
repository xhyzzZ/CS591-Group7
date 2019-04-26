package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.CourseRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Course;
import CS591.GradeManageSystem.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    @Override
    public void save(Course course) {

        try {
            conn = AppConf.getConnection();
            int userId= course.getUserId();
            String courseName = course.getCourseName();
            String year = course.getYear();
            String type = course.getType().toString();
            boolean editable = course.isEditable();

            // pre-process the execution
            String exec = String.format("INSERT INTO COURSE(userId, courseName, year, type, editable) VALUES (%d, \'%s\', \'%s\', \'%s\', %b)",
                    userId,
                    courseName,
                    year,
                    type,
                    editable);
            pst = conn.prepareStatement(exec, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating course failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    course.setCourseId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating course failed, no ID obtained.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Course course) {

        try {
            conn = AppConf.getConnection();
            int courseId = course.getCourseId();
            int userId= course.getUserId();
            String courseName = course.getCourseName();
            String year = course.getYear();
            String type = course.getType().toString();
            boolean editable = course.isEditable();

            // pre-process the execution
            String exec =  String.format("UPDATE COURSE SET userId = %d, courseName = \'%s\', year = \'%s\', type = \'%s\', editable = %b WHERE courseID = %d;",
                    userId,
                    courseName,
                    year,
                    type,
                    editable,
                    courseId);
            pst = conn.prepareStatement(exec);
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
            String exec = String.format("DELETE FROM COURSE WHERE courseId = %d", courseId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Course findByCourseId(int courseId) {

        Course course = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM COURSE WHERE courseId = %d;", courseId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                course = new Course(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        Course.Type.valueOf(rs.getString(5)),
                        rs.getBoolean(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return course;
    }

    @Override
    public List<Course> findByCourseName(String courseName) {

        List<Course> courses = new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM COURSE WHERE courseName = \'%s\';", courseName);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                Course course = new Course(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        Course.Type.valueOf(rs.getString(5)),
                        rs.getBoolean(6));
                courses.add(course);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return courses;
    }

    @Override
    public List<Course> findByUserId(int userId) {

        List<Course> courses = new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM COURSE WHERE userId = %d;", userId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                Course course = new Course(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        Course.Type.valueOf(rs.getString(5)),
                        rs.getBoolean(6));
                courses.add(course);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return courses;
    }
}
