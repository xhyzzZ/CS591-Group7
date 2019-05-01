package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Model;
import java.util.List;

public interface ModelRepository {

    void save(Model model);

    void update(Model model);

    List<Model> findByUserId(int userId);

    List<Model> findByUserIdAndModelName(int userId, String modelName);

    Model findByModelId(int modelId);

    void deleteByModelId(int modelId);
}
