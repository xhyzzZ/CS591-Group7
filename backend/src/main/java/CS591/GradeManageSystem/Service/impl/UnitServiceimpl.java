package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.AssignmentRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.CourseRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.StudentRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.UnitRepositoryImpl;
import CS591.GradeManageSystem.Service.UnitService;
import CS591.GradeManageSystem.entity.Assignment;
import CS591.GradeManageSystem.entity.Student;
import CS591.GradeManageSystem.entity.Unit;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

public class UnitServiceimpl implements UnitService {

    private UnitRepositoryImpl unitRepository = new UnitRepositoryImpl();
    private AssignmentRepositoryImpl assignmentRepository = new AssignmentRepositoryImpl();
    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

    @Override
    public void update(Unit unit) {
        unitRepository.update(unit);
    }

    @Override
    public String[][] getUnitContents(int courseId) {
        List<Assignment> assignments = assignmentRepository.findByCourseId(courseId);
        List<Student> students = studentRepository.findByCourseId(courseId);

        String[][] res = new String[students.size()][assignments.size()];
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < assignments.size(); j++) {
                res[i][j] = unitRepository.findByAssignmentIdAndStudentId(assignments.get(j).getAssignmentId(),
                        students.get(i).getStudentId()).getContent();
            }
        }

        return res;
    }

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
