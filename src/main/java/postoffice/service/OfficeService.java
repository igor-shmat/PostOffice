package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.OfficeDAO;
import postoffice.entity.Office;

import java.sql.Connection;
import java.sql.SQLException;

public class OfficeService {
    public void newOffice(Office office) {

        try (Connection connection = ConnectionToDB.connect()){
            DAO<Office> dao = new OfficeDAO(connection);
            if (dao.read(office).getOfficeId() == null) {
                dao.create(office);
                connection.close();
                System.out.println("Office : " + "->" + office.getAddress() + "<-" + " successfully added!");
            } else
                System.out.println("Office with Address : " + "->" + office.getAddress() + "<-" + " already exists!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
