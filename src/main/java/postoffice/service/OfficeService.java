package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.OfficeDAO;
import postoffice.dao.UserDAO;
import postoffice.entity.Office;
import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

public class OfficeService {
    public void createNewOffice(ArrayList<Office> offices) {
        try (Connection connection = ConnectionToDB.connect()) {
            DAO<Office> dao = new OfficeDAO(connection);
            ArrayList<Office> uniqueOffices = new ArrayList<>();
            ArrayList<Office> officesFromDB = dao.read(offices);
            if (officesFromDB.isEmpty()) {
                dao.create(offices);
            } else {
                ListIterator<Office> lstr = offices.listIterator();
                while (lstr.hasNext()) {
                    Office nextOffice = lstr.next();
                    if (officesFromDB.contains(nextOffice)) {
                        System.out.println("Office with address : " + "->" + nextOffice.getAddress() + "<-" + " already exists!");
                        lstr.remove();
                    } else {
                        uniqueOffices.add(nextOffice);
                    }
                }
                if (!uniqueOffices.isEmpty()) {
                    dao.create(uniqueOffices);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Office> getAllOffices(){
        ArrayList<Office>parcels = null;
        try (Connection connection = ConnectionToDB.connect()) {
            OfficeDAO dao = new OfficeDAO(connection);
            parcels = dao.getAllOffices();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parcels;
    }
}
