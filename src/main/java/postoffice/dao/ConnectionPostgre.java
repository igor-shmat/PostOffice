package postoffice.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgre {
    public void connection(){
        try {
            ConnectionPostgre connectionPostgre = (ConnectionPostgre) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
