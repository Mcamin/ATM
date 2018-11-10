import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBsetup {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://ecinstance.cnb5pn3mjcmy.eu-central-1.rds.amazonaws.com:3306/myAtm";
    private static final String USER = "admin";
    private static final String PASS = "zg_7YpTh_9)e{~.5";
    private static Connection conn = null;

    static Connection connect() {
        //System.out.println("Load MySQL JDBC driver");
        try {
            Class.forName(JDBC_DRIVER);
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");


        } catch (SQLException e) {
            System.out.println("Connection to database failed.");
        }
        return null;
    }
    static void close(Connection c){
        try {
            c.close();
        } catch (SQLException e1) {
            System.out.println("Could not Close the connection.");
        }
    }
}