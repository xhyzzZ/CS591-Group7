package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.UserRepositoryImpl;
import CS591.GradeManageSystem.Service.UserService;
import CS591.GradeManageSystem.entity.User;

public class UserServiceImpl implements UserService {

    private static final int SUCCESS = 0;
    private static final int USERALREADYEXIST = 1;
    private static final int PASSWORDNOTEQUAL = 2;

    private UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private ModelServiceImpl modelService = new ModelServiceImpl();

    // 0: success, 1: no such user, 2: password is wrong
    @Override
    public int checkLogin(String username, String password) {
        if (userRepository.findByUsername(username) == null) return 1;
        if (userRepository.findByUsernameAndPassword(username, password) == null) return 2;
        return 0;
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    // 0: success, 1: user already exists, 2: passwords not equal
    @Override
    public int register(String username, String password, String confirm) {
        if (!password.equals(confirm)) return PASSWORDNOTEQUAL;
        User user = userRepository.findByUsername(username);
        if (user != null) return USERALREADYEXIST;
        user = new User(username, password);
        userRepository.save(user);
        modelService.createDefault(user.getUserId());
        return SUCCESS;
    }
}
