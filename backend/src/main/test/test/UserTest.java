package test;

import CS591.GradeManageSystem.DAO.Impl.UserRepositoryImpl;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTest {

    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    private void initialize() {

        try {
            conn = AppConf.getConnection();

            String exec = "DELETE FROM USER;";

            pst = conn.prepareStatement(exec);

            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void save() {

        try {
            initialize();

            User user = new User("tester1", "test");
            userRepository.save(user);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM USER WHERE userId = %d;", user.getUserId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            String username = "";
            String password = "";
            while (rs.next()) {
                username = rs.getString(2);
                password = rs.getString(3);
            }

            Assert.assertEquals("tester1", username);
            Assert.assertEquals("test", password);

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void update() {

        try {
            initialize();

            User user = new User("tester2", "test");
            userRepository.save(user);

            user.setPassword("test2");
            userRepository.update(user);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM USER WHERE userId = %d;", user.getUserId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            String username = "";
            String password = "";
            while (rs.next()) {
                username = rs.getString(2);
                password = rs.getString(3);
            }

            Assert.assertEquals("tester2", username);
            Assert.assertEquals("test2", password);

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByUserId() {
        try {
            initialize();

            User user = new User("tester3", "test");
            userRepository.save(user);

            User ret = userRepository.findByUserId(user.getUserId());

            Assert.assertEquals("tester3", ret.getUsername());
            Assert.assertEquals("test", ret.getPassword());

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByUsername() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec = "INSERT INTO USER(username, password) VALUES('tester4', 'test');";

            pst = conn.prepareStatement(exec);
            pst.executeUpdate();

            User user = userRepository.findByUsername("tester4");

            Assert.assertEquals("test", user.getPassword());

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByUsernameAndPassword() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec = "INSERT INTO USER(username, password) VALUES('tester5', 'test');";

            pst = conn.prepareStatement(exec);
            pst.executeUpdate();

            User user = userRepository.findByUsernameAndPassword("tester5", "test");

            Assert.assertNotNull(user);

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByUserId() {
        try {
            initialize();

            User user = new User("tester6", "test");
            userRepository.save(user);

            userRepository.deleteByUserId(user.getUserId());

            User ret = userRepository.findByUserId(user.getUserId());

            Assert.assertNull(ret);

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByUsername() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec = "INSERT INTO USER(username, password) VALUES('tester7', 'test');";

            pst = conn.prepareStatement(exec);
            pst.executeUpdate();

            userRepository.deleteByUsername("tester7");

            User user = userRepository.findByUsername("tester7");

            Assert.assertNull(user);

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
