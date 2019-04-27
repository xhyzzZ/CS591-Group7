package CS591.GradeManageSystem.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class AppConf {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk";
    private static final String username = "root";
    private static final String password = "19951029";

    private static Connection conn = null;

    static {
        try {
            Class.forName(driver);
            print("Successfully load Mysql database");
        } catch (Exception ex) {
            print("Load failed");
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
