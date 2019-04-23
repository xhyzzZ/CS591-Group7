package CS591.GradeManageSystem.Service;

import CS591.GradeManageSystem.entity.User;

public interface UserService {
    //login
    User login(String username, String password);

    //register
    int register(String username, String password, String confirm);
}
