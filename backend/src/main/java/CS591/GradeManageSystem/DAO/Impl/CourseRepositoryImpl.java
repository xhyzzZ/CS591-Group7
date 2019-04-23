package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.CourseRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Course;
import CS591.GradeManageSystem.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            // pre-process the execution
            String exec =  String.format("INSERT INTO COURSE(userId, courseName, year, type) VALUES (%d, %s, %s, %s)",
                    userId,
                    courseName,
                    year,
                    type);
            pst = conn.prepareStatement(exec);
            int id = pst.executeUpdate();
            course.setCourseId(id);
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
    public void update(Course course) {

        try {
            conn = AppConf.getConnection();
            int courseId = course.getCourseId();
            int userId= course.getUserId();
            String courseName = course.getCourseName();
            String year = course.getYear();
            String type = course.getType().toString();

            // pre-process the execution
            int count = 0;
            String exec =  String.format("UPDATE COURSE(userId, courseName, year, type) VALUES (%d, %s, %s, %s) WHERE courseID = %s",
                    userId,
                    courseName,
                    year,
                    type,
                    courseId);
            pst = conn.prepareStatement(exec);
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
    public void deleteByCourseId(int id) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM COURSE WHERE courseId = %s", id);
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
    public Course findByCourseId(int id) {

        Course course = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM USER WHERE courseId = '%d'", id);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                course = new Course(
                        rs.getInt("courseId"),
                        rs.getInt("userId"),
                        rs.getString("courseName"),
                        rs.getString("year"),
                        Course.Type.valueOf(rs.getString("type")));
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

        return course;
    }

    @Override
    public List<Course> findByCourseName(String courseName) {


        List<Course> courses = new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM USER WHERE courseName = '%s'", courseName);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                Course course = new Course(
                        rs.getInt("courseId"),
                        rs.getInt("userId"),
                        rs.getString("courseName"),
                        rs.getString("year"),
                        Course.Type.valueOf(rs.getString("type")));
                courses.add(course);
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

        return courses;
    }

    @Override
    public List<Course> findByUserId(int userId) {

        List<Course> courses = new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM USER WHERE userId = '%d'", userId);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                Course course = new Course(
                        rs.getInt("courseId"),
                        rs.getInt("userId"),
                        rs.getString("courseName"),
                        rs.getString("year"),
                        Course.Type.valueOf(rs.getString("type")));
                courses.add(course);
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

        return courses;
    }
}
