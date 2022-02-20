package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.SendingParcelDAO;
import postoffice.entity.SendingParcel;
import postoffice.enums.ParcelStatus;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadParcelService extends Thread {
    @Override
    public void run() {

        try {

            while (checkNewParcels().isEmpty()) {
                System.out.println(Thread.currentThread().getName() +" waiting!");
            }
            System.out.println(Thread.currentThread().getName() +" start!");

            while (!checkNewParcels().isEmpty()) {
                Long startTime = System.currentTimeMillis();
                Long startCheck = System.currentTimeMillis();
                ArrayList<SendingParcel> parcels = checkNewParcels();
                Long endCheck = System.currentTimeMillis();
                Long delayCheck = endCheck - startCheck;
                for(SendingParcel parcel: parcels){
                    parcel.setParcelStatus(ParcelStatus.generateRandomStatus());
                    LocalDateTime start = parcel.getUpdateStatus();
                    LocalDateTime end = parcel.getCreateDate();
                    Duration duration = Duration.between(end,start);
                    Long time = TimeUnit.MILLISECONDS.convert(duration);
                    System.out.println(time);
                    if(time > 4000){
                        parcel.setParcelStatus(ParcelStatus.OVERDUE);

                    }
                }
                batchUpdateParcel(parcels);
                NotificationService notificationService = new NotificationService();
                notificationService.batchCreateNotification(parcels);
                Long endTime = System.currentTimeMillis();
                Long delay =endTime - startTime;
                Thread.sleep(1000-delay-delayCheck);
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

    private void batchUpdateParcel(ArrayList<SendingParcel> parcels) {
        try (Connection connection = ConnectionToDB.connect()) {
            SendingParcelDAO sendingParcelDAO = new SendingParcelDAO(connection);
            sendingParcelDAO.batchUpdate(parcels);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
