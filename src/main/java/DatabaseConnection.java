import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static String MYSQL_HOST = "jdbc:mysql://localhost/details";
    private static String MYSQL_USER_NAME = "root";
    private static String MYSQL_PASSWORD = "Adityasingh@12345";

    private static volatile Connection connection;

    public static Connection getConnectionInSingleTon() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(MYSQL_HOST, MYSQL_USER_NAME, MYSQL_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL Exception while Creating Mysql Connection " + MYSQL_HOST + " With User " + MYSQL_USER_NAME);
            }
        }
        return connection;
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseConnection.class) {
                if(connection == null) {
                    try {
                        connection = DriverManager.getConnection(MYSQL_HOST, MYSQL_USER_NAME, MYSQL_PASSWORD);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("SQL Exception while Creating Mysql Connection " + MYSQL_HOST + " With User " + MYSQL_USER_NAME);
                    }
                }
            }
        }
        return connection;
    }

    public static Connection getConnectionNonSingleTon() {
        Connection mySQLConnection = null;
        try {
            mySQLConnection = DriverManager.getConnection(MYSQL_HOST, MYSQL_USER_NAME, MYSQL_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception while Creating Mysql Connection " + MYSQL_HOST + " With User " + MYSQL_USER_NAME);
        }
        return mySQLConnection;
    }
}


