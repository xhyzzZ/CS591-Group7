package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Course;
import java.util.List;

public interface CourseRepository {

    List<Course> getCourses();

    void save(Course course);

    void update(Course course);

    void deleteByCourseId(int id);

    Course findByCourseId(int id);

    List<Course> findByCourseName(String courseName);

    List<Course> findByUserId(int userId);


}
