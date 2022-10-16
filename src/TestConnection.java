import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;


public class TestConnection {
    public static final String USER_NAME = "croot";
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Connection connection;
    public static Statement statement;

    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Проверяем наличие JDBC драйвера для работы с БД
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);// Cоединение с БД
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
        return connection;
    }

    public static void createTable(String annotationTabel, Connection connection) throws SQLException {

        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.execute(annotationTabel);
            System.out.println("Таблица создана!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteTable(String deleteRequest, Connection connection){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(deleteRequest);
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void insertToDataBase(String request, Connection connection) throws SQLException {
        connection.createStatement().executeUpdate(request);
    }

    public static void insertListToDataBase(List<String> insertRequests, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        for (String a: insertRequests) {
            statement.executeUpdate(a);
        }
    }

    public static ResultSet getResultSet(String request, Connection connection) throws SQLException {
        return connection.createStatement().executeQuery(request);
    }
}

