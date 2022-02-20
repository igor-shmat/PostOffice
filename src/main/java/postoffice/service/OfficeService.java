package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.OfficeDAO;
import postoffice.entity.Office;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OfficeService {
    public void newOffice(ArrayList<Office> offices) {
        try (Connection connection = ConnectionToDB.connect()) {
            DAO<Office> dao = new OfficeDAO(connection);
            ArrayList<Office> clearUsers = new ArrayList<>();
            for (Office office : offices) {
                if (dao.read(office).getOfficeId() == null) {
                    clearUsers.add(office);
                } else
                    System.out.println("User with email : " + "->" + office.getAddress() + "<-" + " already exists!");
            }
            if (!clearUsers.isEmpty()) {
                dao.create(clearUsers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
