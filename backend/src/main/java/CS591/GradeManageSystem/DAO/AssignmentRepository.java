package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Assignment;

import java.util.List;

public interface AssignmentRepository {

    // assignmentId     courseId(int)     assignmentName      weight       addPoint      extraBonus

    List<Assignment> findByCourseId(int courseId);

    void save(Assignment assignment);

    void update(Assignment assignment);

    void deleteByAssignmentId(int assignmentId);


}
