package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.ModelRepositoryImpl;
import CS591.GradeManageSystem.Service.ModelService;
import CS591.GradeManageSystem.entity.Model;

public class ModelServiceImpl implements ModelService {

    @Override
    public void save(Model model) {
        ModelRepositoryImpl modelRepository = new ModelRepositoryImpl();
        modelRepository.save(model);
    }
}
