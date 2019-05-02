package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.ModelRepositoryImpl;
import CS591.GradeManageSystem.Service.ModelService;
import CS591.GradeManageSystem.entity.Model;

import java.util.List;

public class ModelServiceImpl implements ModelService {

    private ModelRepositoryImpl modelRepository = new ModelRepositoryImpl();

    @Override
    public Model createModel(int userId, String modelName, String columnName, int weight, int maxPoint, boolean addPoint, boolean extraBonus, boolean fix) {
        Model model = new Model(userId, modelName, columnName, weight, maxPoint, addPoint, extraBonus, fix);
        modelRepository.save(model);
        return model;
    }

    @Override
    public List<Model> findByUserId(int userId) {
        return modelRepository.findByUserId(userId);
    }

    @Override
    public List<Model> findByUserIdAndModelName(int userId, String modelName) {
        return modelRepository.findByUserIdAndModelName(userId, modelName);
    }

    @Override
    public void createDefault(int userId) {
        Model firstName = new Model(userId, "DEFAULT", "firstName", 0, 0, false, false, true);
        Model middleName = new Model(userId, "DEFAULT", "middleName", 0, 0, false, false, true);
        Model lastName = new Model(userId, "DEFAULT", "lastName", 0, 0, false, false, true);
        Model studentId = new Model(userId, "DEFAULT", "studentId", 0, 0, false, false, true);
        Model email = new Model(userId, "DEFAULT", "email", 0, 0, false, false, true);
        Model graduate = new Model(userId, "DEFAULT", "Graduate/Undergraduate", 0, 0, false, false, true);
        modelRepository.save(firstName);
        modelRepository.save(middleName);
        modelRepository.save(lastName);
        modelRepository.save(studentId);
        modelRepository.save(email);
        modelRepository.save(graduate);
    }

    @Override
    public void deleteModel(int modelId) {
        modelRepository.deleteByModelId(modelId);
    }


}
