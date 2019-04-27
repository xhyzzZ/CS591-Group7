package CS591.GradeManageSystem.config;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TableInitialize {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    public static void initialize() {

        try {
            conn = AppConf.getConnection();

            // initialize user table
            String exec1 = "CREATE TABLE IF NOT EXISTS USER (userId INT AUTO_INCREMENT, username VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, PRIMARY KEY (userId))  ENGINE=INNODB";
            pst = conn.prepareStatement(exec1);
            pst.executeUpdate();

            // initialize course table
            String exec2 = "CREATE TABLE IF NOT EXISTS COURSE (courseId INT AUTO_INCREMENT, userId INT NOT NULL, courseName VARCHAR(255) NOT NULL, year VARCHAR(255) NOT NULL, type VARCHAR(255) NOT NULL, editable BOOLEAN NOT NULL, PRIMARY KEY (courseId))  ENGINE=INNODB";
            pst = conn.prepareStatement(exec2);
            pst.executeUpdate();

            // initialize assignment table
            String exec3 = "CREATE TABLE IF NOT EXISTS ASSIGNMENT (assignmentId INT AUTO_INCREMENT, courseId INT NOT NULL, assignmentName VARCHAR(255) NOT NULL, weight INT NOT NULL, addPoint BOOLEAN NOT NULL, extraBonus BOOLEAN NOT NULL, fix BOOLEAN NOT NULL, PRIMARY KEY (assignmentId))  ENGINE=INNODB";
            pst = conn.prepareStatement(exec3);
            pst.executeUpdate();

            // initialize student table
            String exec4 = "CREATE TABLE IF NOT EXISTS STUDENT (studentId INT AUTO_INCREMENT, courseId INT NOT NULL, note VARCHAR(255) NOT NULL, PRIMARY KEY (studentId))  ENGINE=INNODB";
            pst = conn.prepareStatement(exec4);
            pst.executeUpdate();

            // initialize unit table
            String exec5 = "CREATE TABLE IF NOT EXISTS UNIT (unitId INT AUTO_INCREMENT, courseId INT NOT NULL, studentId INT NOT NULL, assignmentId INT NOT NULL, content VARCHAR(255) NOT NULL, note VARCHAR(255) NOT NULL, PRIMARY KEY (unitId))  ENGINE=INNODB";
            pst = conn.prepareStatement(exec5);
            pst.executeUpdate();

            // initialize model table
            String exec6 = "CREATE TABLE IF NOT EXISTS MODEL (modelId INT AUTO_INCREMENT, modelName VARCHAR(255) NOT NULL, columnName VARCHAR(255) NOT NULL, weight INT NOT NULL, addPoint BOOLEAN NOT NULL, extraBonus BOOLEAN NOT NULL, fix BOOLEAN NOT NULL, PRIMARY KEY (modelId))  ENGINE=INNODB";
            pst = conn.prepareStatement(exec6);
            pst.executeUpdate();

            // delete default
            String exec12 = "DELETE FROM MODEL WHERE modelName = 'DEFAULT'";
            pst = conn.prepareStatement(exec12);
            pst.executeUpdate();

            // default model
            // firstname middlename lastname studentId email
            String exec7 = "INSERT INTO MODEL(modelName, columnName, weight, addPoint, extraBonus, fix) VALUES('DEFAULT', 'firstname', 0, FALSE, FALSE, TRUE);";
            pst = conn.prepareStatement(exec7);
            pst.executeUpdate();

            String exec8 = "INSERT INTO MODEL(modelName, columnName, weight, addPoint, extraBonus, fix) VALUES('DEFAULT', 'middlename', 0, FALSE, FALSE, TRUE);";
            pst = conn.prepareStatement(exec8);
            pst.executeUpdate();

            String exec9 = "INSERT INTO MODEL(modelName, columnName, weight, addPoint, extraBonus, fix) VALUES('DEFAULT', 'lastname', 0, FALSE, FALSE, TRUE);";
            pst = conn.prepareStatement(exec9);
            pst.executeUpdate();

            String exec10 = "INSERT INTO MODEL(modelName, columnName, weight, addPoint, extraBonus, fix) VALUES('DEFAULT', 'studentId', 0, FALSE, FALSE, TRUE);";
            pst = conn.prepareStatement(exec10);
            pst.executeUpdate();

            String exec11 = "INSERT INTO MODEL(modelName, columnName, weight, addPoint, extraBonus, fix) VALUES('DEFAULT', 'email', 0, FALSE, FALSE, TRUE);";
            pst = conn.prepareStatement(exec11);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
