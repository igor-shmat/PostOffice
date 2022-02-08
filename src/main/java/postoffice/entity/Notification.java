package postoffice.entity;

import lombok.Data;
import postoffice.enums.NotificationStatus;

@Data
public class Notification {
    private Long parcelId;
    private String text;
    private NotificationStatus notificationStatus;

}
