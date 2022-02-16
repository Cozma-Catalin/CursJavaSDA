import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class OracleDataBaseConnection implements DBConnection {


    private OracleDataBaseConnection(){}


    public static Connection getConnection() {
        final String URL = "jdbc:oracle://localhost:3306/school?serverTimezone=UTC";
        final String USER_NAME = "root";
        final String PASSWORD = "123456";

        Connection conn = null;
        {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
