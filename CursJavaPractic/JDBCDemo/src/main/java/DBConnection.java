import java.sql.Connection;

public interface DBConnection extends Connection {
    static Connection getConnection(String conn) {
        if(conn.equalsIgnoreCase("MySQL")) {
            return MySQLDataBaseConnection.getConnection();
        } else
            return OracleDataBaseConnection.getConnection();

    }

}
