package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.NotificationDAO;
import postoffice.entity.Notification;
import postoffice.entity.SendingParcel;
import postoffice.enums.NotificationStatus;
import postoffice.enums.ParcelStatus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotificationService {
    public void createNotification(ArrayList<SendingParcel> parcels) {
        try (Connection connection = ConnectionToDB.connect()) {
            NotificationDAO notificationDAO = new NotificationDAO(connection);
            ArrayList<Notification> notifications = new ArrayList<>();
            for (SendingParcel parcel : parcels) {
                if (parcel.getParcelStatus().equals(ParcelStatus.DELIVERED)) {
                    Notification notification = new Notification();
                    notification.setParcelId(parcel.getParcelId());
                    notification.setNotificationStatus(NotificationStatus.SENT);
                    notification.setTexts("Ваша посылка " + parcel.getParcelId() + " успешно доставлена!");
                    notifications.add(notification);
                }
                if (parcel.getParcelStatus().equals(ParcelStatus.OVERDUE)){
                    Notification notification = new Notification();
                    notification.setParcelId(parcel.getParcelId());
                    notification.setNotificationStatus(NotificationStatus.SENT);
                    notification.setTexts("Ваша посылка " + parcel.getParcelId() + " отправлена обратно отправителю!");
                    notifications.add(notification);
                }
            }
            notificationDAO.create(notifications);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
