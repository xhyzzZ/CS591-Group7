package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.*;
import CS591.GradeManageSystem.DAO.ModelRepository;
import CS591.GradeManageSystem.Service.CourseService;
import CS591.GradeManageSystem.entity.Assignment;
import CS591.GradeManageSystem.entity.Course;
import CS591.GradeManageSystem.entity.Model;
import CS591.GradeManageSystem.entity.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseServiceImpl implements CS591.GradeManageSystem.Service.CourseService {

    private CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();
    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    private AssignmentRepositoryImpl assignmentRepository = new AssignmentRepositoryImpl();
    private UnitRepositoryImpl unitRepository = new UnitRepositoryImpl();
    private ModelRepositoryImpl modelRepository = new ModelRepositoryImpl();

    @Override
    public void update(Course course) {
        courseRepository.update(course);
    }

    @Override
    public List<Course> getCourses(int userId) {
        return courseRepository.findByUserId(userId);
    }

    @Override
    public Course createCourse(int userId, String courseName, String year, String type, String modelName) {
        List<Model> models = modelRepository.findByUserIdAndModelName(userId, modelName);
        Course course = new Course(userId, courseName, year, type, true);
        courseRepository.save(course);
        models.sort(Comparator.comparingInt(Model::getModelId));
        for (Model model : models) {
            Assignment assignment = new Assignment(course.getCourseId(),
                    model.getColumnName(),
                    model.getWeight(),
                    model.getMaxPoint(),
                    model.isAddPoint(),
                    model.isExtraBonus(),
                    model.isFix());
            assignmentRepository.save(assignment);
        }

        return course;
    }

    @Override
    public void deleteCourse(int courseId) {
        unitRepository.deleteByCourseId(courseId);
        assignmentRepository.deleteByCourseId(courseId);
        studentRepository.deleteByCourseId(courseId);
        courseRepository.deleteByCourseId(courseId);
    }
}
