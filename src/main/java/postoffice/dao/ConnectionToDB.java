package postoffice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {
    private volatile static Connection connection ;
    public synchronized static Connection connect()  {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
