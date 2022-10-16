import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {
    private Connection connection = null;
    private Statement statement = null;

    public Data() throws SQLException {
        this.connection = TestConnection.getDBConnection();
        this.statement = connection.createStatement();
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null)
            connection.close();
        if (statement != null)
            statement.close();

        connection = null;
        statement = null;

    }

    public void setConnection() {
        connection = TestConnection.getDBConnection();
    }

    public void setStatement() throws SQLException {
        setConnection();
        statement = connection.createStatement();
    }
}
