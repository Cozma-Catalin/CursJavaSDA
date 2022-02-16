import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQLDataBaseConnection implements DBConnection  {


    private MySQLDataBaseConnection(){}


    public static Connection getConnection() {
         final String URL = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
         final String USER_NAME = "root";
         final String PASSWORD = "123456";

        Connection conn = null;
        {
            try {

                MysqlConnectionPoolDataSource db = new MysqlConnectionPoolDataSource();
                db.setURL(URL);
                db.setUser(USER_NAME);
                db.setPassword(PASSWORD);

                PooledConnection pconn = db.getPooledConnection();

                conn = pconn.getConnection();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
