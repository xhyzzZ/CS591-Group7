package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.AssignmentRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.CourseRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.StudentRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.UnitRepositoryImpl;
import CS591.GradeManageSystem.Service.UnitService;
import CS591.GradeManageSystem.entity.Assignment;
import CS591.GradeManageSystem.entity.Student;
import CS591.GradeManageSystem.entity.Unit;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

public class UnitServiceimpl implements UnitService {

    private UnitRepositoryImpl unitRepository = new UnitRepositoryImpl();
    private AssignmentRepositoryImpl assignmentRepository = new AssignmentRepositoryImpl();
    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

    @Override
    public Map<Assignment, Map<Student, Unit>> getUnits(int courseId) {
        List<Unit> units = unitRepository.findByCourseId(courseId);
        Map<Assignment, Map<Student, Unit>> ret = new HashMap<>();
        for (Unit unit : units) {
            Assignment assignment = assignmentRepository.findByAssignmentId(unit.getAssignmentId());
            Student student = studentRepository.findByStudentId(unit.getStudentId());
            if (!ret.containsKey(assignment)) ret.put(assignment, new HashMap<>());
            ret.get(assignment).put(student, unit);
        }

        return ret;
    }

    @Override
    public Unit createUnit(int courseId, int studentId, int assignmentId, String content, String note) {
        Unit unit = new Unit(courseId, studentId, assignmentId,content, note);
        unitRepository.save(unit);
        return unit;
    }

    @Override
    public void deleteUnit(int unitId) {
        unitRepository.deleteByUnitId(unitId);
    }
}
