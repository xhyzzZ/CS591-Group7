package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.User;
import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    void save(User user);

    void update(User user);

    void deleteById(Integer id);

    User findById(Integer id);

    void deleteByUsername(String username);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
