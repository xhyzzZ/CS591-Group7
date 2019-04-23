package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Assignment;
import com.sun.tools.javac.util.List;

public interface AssignmentService {

    List<Assignment> getAssignments(int courseId);

    void deleteById(int assignmentId);

    void createAssignment();
}
