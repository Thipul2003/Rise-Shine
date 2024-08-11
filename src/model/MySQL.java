package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL {

    private static Connection connection;
    private static final String DB = "rise&shine_db";
    private static final String PORT = "3306";
    private static final String PASSWORD = "D1t2d0le@";
    private static final String USERNAME = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT + "/" + DB, USERNAME, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet execute(String query) throws Exception {
        Statement statement = connection.createStatement();

        if (query.startsWith("SELECT") || query.startsWith("select")) {

            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } else {
            int result = statement.executeUpdate(query);
            return null;
        }
    }
}
