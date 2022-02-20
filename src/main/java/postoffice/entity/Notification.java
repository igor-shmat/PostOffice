package postoffice.entity;

import postoffice.enums.NotificationStatus;

import java.util.Objects;

public class Notification {
    private Long parcelId;
    private NotificationStatus notificationStatus;
    private String texts;


    public Long getParcelId() {
        return parcelId;
    }

    public void setParcelId(Long parcelId) {
        this.parcelId = parcelId;
    }

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(parcelId, that.parcelId) && notificationStatus == that.notificationStatus && Objects.equals(texts, that.texts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parcelId, notificationStatus, texts);
    }
}
