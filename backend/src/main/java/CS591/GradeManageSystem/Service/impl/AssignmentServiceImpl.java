package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.AssignmentRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.UnitRepositoryImpl;
import CS591.GradeManageSystem.entity.Assignment;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AssignmentServiceImpl implements CS591.GradeManageSystem.Service.AssignmentService {

    private AssignmentRepositoryImpl assignmentRepository = new AssignmentRepositoryImpl();
    private UnitRepositoryImpl unitRepository = new UnitRepositoryImpl();

    @Override
    public List<Assignment> getAssignments(int courseId) {
        List<Assignment> assignments = assignmentRepository.findByCourseId(courseId);
        assignments.sort(Comparator.comparingInt(Assignment::getAssignmentId));
        return assignments;
    }

    @Override
    public void deleteById(int assignmentId) {
        unitRepository.deleteByAssignmentId(assignmentId);
        assignmentRepository.deleteByAssignmentId(assignmentId);
    }

    @Override
    public Assignment createAssignment(int courseId, String assignmentName, int weight, boolean addPoint, boolean extraBonus, boolean fix) {
        Assignment assignment = new Assignment(courseId, assignmentName, weight, addPoint, extraBonus, fix);
        assignmentRepository.save(assignment);
        return assignment;
    }
}
