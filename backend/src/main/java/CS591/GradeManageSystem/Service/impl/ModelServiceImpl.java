package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.ModelRepositoryImpl;
import CS591.GradeManageSystem.entity.Model;

public class ModelServiceImpl {

    public void save(Model model) {
        ModelRepositoryImpl modelRepository = new ModelRepositoryImpl();
        modelRepository.save(model);
    }
}
