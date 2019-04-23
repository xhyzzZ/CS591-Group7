package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Course;
import java.util.List;

public interface CourseRepository {

    // courseId       userId       courseName         year         type/summer/fall/spring
    List<Course> getCourses();

    void save(Course course);

    void update(Course course);

    void deleteByCourseId(int courseId);

    Course findByCourseId(int courseId);

    List<Course> findByCourseName(String courseName);

    List<Course> findByUserId(int userId);


}
