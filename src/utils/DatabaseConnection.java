package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by usha on 4/3/2017.
 */
public class DatabaseConnection {

    private DatabaseConnection() {
    }

    public static PreparedStatement getPreparedStatement(String query) {
        Connection connection = getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstm;
    }

    private static Connection getConnection(String url, String username, String password) {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
