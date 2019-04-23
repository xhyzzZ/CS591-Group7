package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.AssignmentRepositoryImpl;
import CS591.GradeManageSystem.entity.Assignment;
import java.util.List;

public class AssignmentServiceImpl implements CS591.GradeManageSystem.Service.AssignmentService {

    private AssignmentRepositoryImpl assignmentRepository = new AssignmentRepositoryImpl();

    @Override
    public List<Assignment> getAssignments(int courseId) {
        return assignmentRepository.findByCourseId(courseId);
    }

    @Override
    public void deleteById(int assignmentId) {
        assignmentRepository.deleteByAssignmentId(assignmentId);
    }

    @Override
    public Assignment createAssignment(int courseId, String assignmentName, int weight, boolean addPoint, boolean extrapoints) {
        Assignment assignment = new Assignment(courseId, assignmentName, weight, addPoint, extrapoints);
        assignmentRepository.save(assignment);
        return assignment;
    }
}
