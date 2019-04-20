package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Statistics;

import java.util.List;

public interface StatisticsRepository {

    // assignmentId    median    average   max   min   stdDev
    List<Statistics> getStatistics();

    void save(Statistics statistics);

    void update(Statistics statistics);

    void deleteByAssignmentId(int assignmentId);

}
