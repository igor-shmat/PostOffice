package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.OfficeDAO;
import postoffice.entity.Office;

import java.sql.Connection;
import java.sql.SQLException;

public class OfficeService {
    public void newOffice(Office office) {
        try {
            Connection connection;
            DAO<Office, String> dao = new OfficeDAO(connection = ConnectionToDB.connect());
            dao.save(office);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
