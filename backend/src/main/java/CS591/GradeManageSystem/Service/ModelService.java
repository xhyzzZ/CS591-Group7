package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.Model;

public interface ModelService {
    Model createModel(String modelName, String columnName, int weight, int maxPoint, boolean addPoint, boolean extraBonus, boolean fix);
}
