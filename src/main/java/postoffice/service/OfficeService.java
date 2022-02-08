package postoffice.service;

import postoffice.dao.DAO;
import postoffice.dao.OfficeDAO;
import postoffice.entity.Office;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OfficeService {
    public void newOffice(Office office) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
            DAO<Office, String> dao = new OfficeDAO(connection);
            dao.save(office);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
