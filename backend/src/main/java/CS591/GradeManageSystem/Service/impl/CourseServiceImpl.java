package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.CourseRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.StudentRepositoryImpl;
import CS591.GradeManageSystem.entity.Course;

import java.util.List;

public class CourseServiceImpl implements CS591.GradeManageSystem.Service.CourseService {

    private CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();
    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

    @Override
    public List<Course> getCourses(int userId) {
        return courseRepository.findByUserId(userId);
    }

    @Override
    public Course createCourse(int userId, String courseName, String year, String type) {
        Course course = new Course(userId, courseName, year, type);
        courseRepository.save(course);
        return course;
    }

    @Override
    public void deleteCourse(int courseId) {
        studentRepository.deleteByCourseId(courseId);
        courseRepository.deleteByCourseId(courseId);
    }
}
