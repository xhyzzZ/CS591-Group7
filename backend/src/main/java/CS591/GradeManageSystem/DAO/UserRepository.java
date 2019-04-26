package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.User;
import java.util.List;

public interface UserRepository {

    // userId            userName          password

    List<User> findAll();

    void save(User user);

    void update(User user);

    void deleteByUserId(Integer id);

    User findByUserId(Integer id);

    void deleteByUsername(String username);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
