package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Grade;
import java.util.List;

public interface GradeRepository {

    // gradeId       studentId          assignmentId        score       note
    void save(Grade grade);

    void deleteById(Integer gradeId);

    void update(Grade grade);

    Grade findById(Integer gradeId);

    Grade findByStudentId(Integer studentId);

    Grade findByAssignmentIdAndStudentId(Integer assignmentId, Integer studentId);
}
