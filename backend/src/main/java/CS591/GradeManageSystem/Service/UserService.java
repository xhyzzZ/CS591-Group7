package CS591.GradeManageSystem.Service;

public interface UserService {
    //login
    public boolean login(String username, String password);

    //register
    public int register(String username, String password, String confirm);
}
