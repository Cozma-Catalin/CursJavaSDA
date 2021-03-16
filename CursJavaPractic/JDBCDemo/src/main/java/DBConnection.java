import java.sql.Connection;

public interface DBConnection {
    static Connection getMySQLConnection() {
        return MySQLDataBaseConnection.getConnection();
    }

}
