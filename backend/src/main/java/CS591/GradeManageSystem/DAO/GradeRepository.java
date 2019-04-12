package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Grade;
import java.util.List;

public interface GradeRepository {
    List<Grade> getGrades();

    void save(Grade grade);

    void deleteById(Integer studentId);

    Grade findById(Integer studentId);

    Grade findBySingleScore(Integer studentId, Integer gradeId, Integer assignmentId);

    Grade findByTotalScore(Integer studentId, Integer assignmentId);

    Grade findByNote();

}
