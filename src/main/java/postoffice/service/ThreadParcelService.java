package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.SendingParcelDAO;
import postoffice.entity.SendingParcel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThreadParcelService extends Thread {

    @Override
    public void run() {
        try {
            while (checkNewParcels().isEmpty()) {
                System.out.println("1");
            }
            while (!checkNewParcels().isEmpty()) {
                batchUpdate(checkNewParcels());
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private ArrayList<SendingParcel> checkNewParcels() throws InterruptedException {
        List<SendingParcel> parcels = null;
        try (Connection connection = ConnectionToDB.connect()) {
            SendingParcelDAO sendingParcelDAO = new SendingParcelDAO(connection);
            parcels = sendingParcelDAO.getNewParcels();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<SendingParcel>) parcels;
    }

    private void batchUpdate(ArrayList<SendingParcel> parcels) {
        try (Connection connection = ConnectionToDB.connect()) {
            SendingParcelDAO sendingParcelDAO = new SendingParcelDAO(connection);
            sendingParcelDAO.batchUpdate(parcels);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
