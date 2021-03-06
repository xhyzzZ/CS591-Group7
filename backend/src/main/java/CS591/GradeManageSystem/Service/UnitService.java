package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Assignment;
import CS591.GradeManageSystem.entity.Student;
import CS591.GradeManageSystem.entity.Unit;

import java.util.Map;

public interface UnitService {

    void update(Unit unit);

    Map<Assignment, Map<Student, Unit>> getUnits(int courseId);

    Unit getUnit(int assignmentId, int studentId);

    Unit createUnit(int courseId, int studentId, int assignmentId, String content, String note);

    void deleteUnit(int unitId);
}
