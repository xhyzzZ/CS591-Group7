package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.ModelRepositoryImpl;
import CS591.GradeManageSystem.Service.ModelService;
import CS591.GradeManageSystem.entity.Model;

public class ModelServiceImpl implements ModelService {

    ModelRepositoryImpl modelRepository = new ModelRepositoryImpl();

    @Override
    public Model createModel(String modelName, String columnName, int weight, int maxPoint, boolean addPoint, boolean extraBonus, boolean fix) {
        Model model = new Model(modelName, columnName, weight, maxPoint, addPoint, extraBonus, fix);
        modelRepository.save(model);
        return model;
    }
}
