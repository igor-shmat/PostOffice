package postoffice.entity;

import lombok.Getter;
import lombok.Setter;
import postoffice.enums.NotificationStatus;

@Setter
@Getter
public class Notification {
    private Long parcelId;
    private String text;
    private NotificationStatus notificationStatus;

    public Notification(Long parcelId, String text, NotificationStatus notificationStatus) {
        this.parcelId = parcelId;
        this.text = text;
        this.notificationStatus = notificationStatus;
    }

    public Notification() {
    }
}
