package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Grade;
import java.util.List;

public interface GradeRepository {
    List<Grade> getGrades();

    void save(Grade grade);

    void deleteById(Integer gradeId);

    Grade findById(Integer gradeId);

    Grade findBySingleScore(Integer gradeId, Integer studentId, Integer assignmentId);

    Grade findByTotalScore(Integer gradeId, Integer assignmentId);

    Grade findByNote(Integer gradeId);

}
