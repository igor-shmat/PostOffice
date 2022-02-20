package postoffice.entity;

import postoffice.enums.ParcelStatus;

import java.time.LocalDateTime;

public class SendingParcel {
    private Long parcelId;
    private Users users;
    private Office senderOffice;
    private Office receiverOffice;
    private String receiverPhoneNumber;
    private String receiver_first_name;
    private String receiver_second_name;
    private String receiver_patronymic_name;
    private ParcelStatus parcelStatus;
    private LocalDateTime createDate;
    private LocalDateTime updateStatus;

    public Long getParcelId() {
        return parcelId;
    }

    public void setParcelId(Long parcelId) {
        this.parcelId = parcelId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Office getSenderOffice() {
        return senderOffice;
    }

    public void setSenderOffice(Office senderOffice) {
        this.senderOffice = senderOffice;
    }

    public Office getReceiverOffice() {
        return receiverOffice;
    }

    public void setReceiverOffice(Office receiverOffice) {
        this.receiverOffice = receiverOffice;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getReceiver_first_name() {
        return receiver_first_name;
    }

    public void setReceiver_first_name(String receiver_first_name) {
        this.receiver_first_name = receiver_first_name;
    }

    public String getReceiver_second_name() {
        return receiver_second_name;
    }

    public void setReceiver_second_name(String receiver_second_name) {
        this.receiver_second_name = receiver_second_name;
    }

    public String getReceiver_patronymic_name() {
        return receiver_patronymic_name;
    }

    public void setReceiver_patronymic_name(String receiver_patronymic_name) {
        this.receiver_patronymic_name = receiver_patronymic_name;
    }

    public ParcelStatus getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(ParcelStatus parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(LocalDateTime updateStatus) {
        this.updateStatus = updateStatus;
    }

    @Override
    public String toString() {
        return "SendingParcel{" +
                "parcelId=" + parcelId +
                ", users=" + users +
                ", senderOffice=" + senderOffice +
                ", receiverOffice=" + receiverOffice +
                ", receiverPhoneNumber='" + receiverPhoneNumber + '\'' +
                ", receiver_first_name='" + receiver_first_name + '\'' +
                ", receiver_second_name='" + receiver_second_name + '\'' +
                ", receiver_patronymic_name='" + receiver_patronymic_name + '\'' +
                ", parcelStatus=" + parcelStatus +
                ", createDate=" + createDate +
                ", updateStatus=" + updateStatus +
                '}';
    }
}
