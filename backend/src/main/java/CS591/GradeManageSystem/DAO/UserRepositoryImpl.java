package CS591.GradeManageSystem.DAO;

import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    public List<User> getUsers() {
        List<User> users=  new ArrayList<User>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            pst = conn.prepareStatement("SELECT * FROM USER");

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()){
                User user = new User(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3));
                users.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return users;
    }

    public void save(User user) {
        try {
            conn = AppConf.getConnection();

            String username = user.getUsername();
            String password = user.getPassword();

            // pre-process the execution
            String s = String.format("INSERT INTO USER(username, password) VALUES('%s', '%s');", username, password);
            System.out.println(s);
            pst = conn.prepareStatement(s);

            // execute and get the result set
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deleteById(Long id) {

    }

    public void deleteByUsername(String username) {

    }

    public User findByUsername(String username) {
        return null;
    }

    public User findById(Long id) {
        return null;
    }

    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = new User("junoth", "test");
        userRepository.save(user);
    }
}
