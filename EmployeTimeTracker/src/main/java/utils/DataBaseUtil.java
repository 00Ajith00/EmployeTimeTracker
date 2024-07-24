package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/employeeTimeTracker";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kavi@1503";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
