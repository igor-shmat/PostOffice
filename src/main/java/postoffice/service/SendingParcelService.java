package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.SendingParcelDAO;
import postoffice.entity.SendingParcel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SendingParcelService {
    public void createNewParcels(ArrayList<SendingParcel> parcel) {
        try (Connection connection = ConnectionToDB.connect()) {
            DAO<SendingParcel> dao = new SendingParcelDAO(connection);
            dao.create(parcel);
            System.out.println("Parcels successfully registered!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<SendingParcel> getAllParcels(){
        ArrayList<SendingParcel>parcels = null;
        try (Connection connection = ConnectionToDB.connect()) {
            SendingParcelDAO dao = new SendingParcelDAO(connection);
            parcels = dao.getAllParcels();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parcels;
    }
}
