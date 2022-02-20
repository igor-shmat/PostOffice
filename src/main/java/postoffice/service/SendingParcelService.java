package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.SendingParcelDAO;
import postoffice.entity.SendingParcel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SendingParcelService {
    public void sending(ArrayList<SendingParcel> parcel) {
        try (Connection connection = ConnectionToDB.connect()) {
            DAO<SendingParcel> DAO = new SendingParcelDAO(connection);
            DAO.create(parcel);
            System.out.println("Parcels successfully registered!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
