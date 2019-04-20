package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Grade;
import java.util.List;

public interface GradeRepository {

    // gradeId       studentId          assignmentId        score       note
    List<Grade> getGrades();

    void save(Grade grade);

    void deleteById(Integer gradeId);

    void update(Grade grade);

    Grade findById(Integer gradeId);

    Grade findByStudent(Integer studentId);

    Grade findByAssignment(Integer assignmentId);

    Grade findBySingleScore(Integer gradeId, Integer studentId, Integer assignmentId);

    Grade findByTotalScore(Integer gradeId, Integer assignmentId);

    Grade findByNote(Integer gradeId);

}
