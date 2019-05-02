package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Model;
import java.util.List;

public interface ModelService {
    Model createModel(int userId, String modelName, String columnName, int weight, int maxPoint, boolean addPoint, boolean extraBonus, boolean fix);

    List<Model> findByUserId(int userId);

    List<Model> findByUserIdAndModelName(int userId, String modelName);

    void createDefault(int userId);

    void deleteModel(int modelId);
}
