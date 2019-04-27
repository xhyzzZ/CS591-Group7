package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Unit;
import java.util.List;

public interface UnitRepository {

    // gradeId   courseId  studentId   assignmentId   content   note
    void save(Unit unit);

    void deleteByUnitId(Integer unitId);

    void deleteByCourseIdAndStudentId(Integer CourseId, Integer studentId);

    void deleteByCourseIdAndAssignmentId(Integer CourseId, Integer assignmentId);

    void deleteByCourseId(Integer courseId);

    void update(Unit unit);

    Unit findByUnitId(Integer unitId);

    List<Unit> findByCourseId(Integer courseId);

    Unit findByAssignmentIdAndStudentId(Integer assignmentId, Integer studentId);
}
