package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.SendingParcelDAO;
import postoffice.entity.SendingParcel;

import java.sql.Connection;
import java.sql.SQLException;

public class SendingParcelService {
    public void sending(SendingParcel parcel){
        try(Connection connection = ConnectionToDB.connect()) {
            DAO<SendingParcel> dao = new SendingParcelDAO(connection);
            dao.create(parcel);
            connection.close();
            System.out.println("Parcel successfully registered!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
