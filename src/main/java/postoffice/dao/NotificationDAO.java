package postoffice.dao;

import postoffice.entity.Notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotificationDAO {
    private final Connection connection;

    public NotificationDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(ArrayList<Notification> notifications) {
        try (PreparedStatement statement = connection.prepareStatement(NotificationDAO.SQLNotification.INSERT.QUERY)) {

            for (Notification notification : notifications) {
                statement.setLong(1, notification.getParcelId());
                statement.setString(2, notification.getNotificationStatus().toString());
                statement.setString(3,notification.getTexts());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    enum SQLNotification {
        INSERT("INSERT INTO mono_post.notification (notification_id, parcel_id, notification_status, texts) VALUES (DEFAULT, (?), (?), (?))");

        String QUERY;

        SQLNotification(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}