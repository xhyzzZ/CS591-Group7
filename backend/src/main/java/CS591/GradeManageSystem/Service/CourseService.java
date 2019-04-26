package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses(int userId);

    Course createCourse(int userId, String courseName, String year, String type, String modelName);

    void deleteCourse(int courseId);
}
