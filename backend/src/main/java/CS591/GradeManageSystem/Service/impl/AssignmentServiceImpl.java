package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.AssignmentRepositoryImpl;
import CS591.GradeManageSystem.entity.Assignment;
import java.util.List;

public class AssignmentServiceImpl implements CS591.GradeManageSystem.Service.AssignmentService {

    AssignmentRepositoryImpl assignmentRepository = new AssignmentRepositoryImpl();

    @Override
    public List<Assignment> getAssignments(int courseId) {
        return assignmentRepository.findByCourseId(courseId);
    }

    @Override
    public void deleteById(int assignmentId) {

    }

    @Override
    public void createAssignment(int courseId, String assignmentName, int weight, boolean addPoint, boolean extrapoints) {

    }
}
