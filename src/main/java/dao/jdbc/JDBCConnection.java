package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.*;

public class JDBCConnection {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/hacs";
    private static final String user = "root";
    private static final String password = "1111";

    // JDBC variables for opening and managing connection
    private static Connection con;
    
    private static JDBCConnection instance;
    public static JDBCConnection getInstance(){
        if(instance == null){ instance = new JDBCConnection(); }

        return instance;
    }


    public Connection getConnection(){
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return null;
    }
}