package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Course;
import CS591.GradeManageSystem.entity.User;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses(int userId);

    public Course createCourse(int userId, String courseName, String year, String type);

    public void deleteCourse(int courseId);


}
