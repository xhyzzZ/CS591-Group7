package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.Model;
import java.util.List;

public interface ModelRepository {

    void save(Model model);

    void update(Model model);

    List<Model> findAll();

    List<Model> findByModelName(String modelName);

    Model findByModelId(int modelId);

    void deleteByModelName(String modelName);

    void deleteByModelId(int modelId);
}
