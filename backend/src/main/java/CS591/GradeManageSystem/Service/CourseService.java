package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Course;
import CS591.GradeManageSystem.entity.User;

import java.util.List;

public interface CourseService {

    List<Course> getCourses(int userId);

    Course createCourse(int userId, String courseName, String year, String type);

    void deleteCourse(int courseId);
}
