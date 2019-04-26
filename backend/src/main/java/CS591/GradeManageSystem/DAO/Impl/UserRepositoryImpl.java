package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.UserRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    @Override
    public List<User> findAll() {
        List<User> users=  new ArrayList<User>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = "SELECT * FROM USER;";
            pst = conn.prepareStatement(exec);

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

    @Override
    public void update(User user) {
        try {
            conn = AppConf.getConnection();
            String username = user.getUsername();
            String password = user.getPassword();
            int userId = user.getUserId();

            String exec = String.format("UPDATE USER SET username = \'%s\', password = \'%s\' WHERE userId = %d;", username, password, userId);
            pst = conn.prepareStatement(exec);
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void save(User user) {
        try {
            conn = AppConf.getConnection();

            String username = user.getUsername();
            String password = user.getPassword();

            String exec = String.format("INSERT INTO USER(username, password) VALUES(\'%s\', \'%s\');", username, password);
            pst = conn.prepareStatement(exec, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setUserId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByUserId(Integer userId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM USER WHERE userId = %d;", userId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByUsername(String username) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM USER WHERE username = \'%s\';", username);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
        User user = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM USER WHERE username = \'%s\';", username);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM USER WHERE username = \'%s\' AND password = \'%s\';",
                    username,
                    password);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            rs = pst.executeQuery();

            while(rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public User findByUserId(Integer userId) {
        User user = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM USER WHERE userId = %d;", userId);
            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            while(rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return user;
    }
}
