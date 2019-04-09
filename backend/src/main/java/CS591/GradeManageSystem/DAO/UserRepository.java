package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.entity.User;
import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    void save(User user);

    void deleteById(Long id);

    void deleteByUsername(String username);

    User findByUsername(String username);

    User findById(Long id);
}
