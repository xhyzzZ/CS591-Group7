package CS591.GradeManageSystem.config;

import CS591.GradeManageSystem.utils.Constants;
import java.sql.Connection;
import java.sql.DriverManager;

public class AppConf {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/gradingsystem?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
    private static final String username = "root";
    private static final String password = "";

    private static Connection conn = null;

    static {
        try {
            Class.forName(driver);
            print(Constants.LOADSUCCESS);
        } catch (Exception ex) {
            print(Constants.LOADFAILED);
            ex.printStackTrace();
        }
    }

    // use singleton to get db conn
    public static Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }

        return conn;
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
