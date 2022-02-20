package postoffice.dao;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {
    private static final PGConnectionPoolDataSource connectionPool;

    static {
        connectionPool = new PGConnectionPoolDataSource();
        connectionPool.setServerNames(new String[]{"localhost"});
        connectionPool.setPortNumbers(new int[]{5432});
        connectionPool.setUser("postgres");
        connectionPool.setPassword("123");
    }

    public static Connection connect() {
        try {
            Connection connection = connectionPool.getPooledConnection().getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
