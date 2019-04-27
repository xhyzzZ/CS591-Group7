package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Assignment;
import java.util.List;

public interface AssignmentService {

    List<Assignment> getAssignments(int courseId);

    void deleteById(int courseId, int assignmentId);

    Assignment createAssignment(int courseId, String assignmentName, int weight, boolean addPoint, boolean extraBonus, boolean fix);
}
