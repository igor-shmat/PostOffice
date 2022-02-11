package postoffice.entity;

import postoffice.enums.ParcelStatus;

import java.time.LocalDateTime;

public class SendingParcel {
    private Long parcelId;
    private Users users;
    private Office senderOffice;
    private Office receiverOffice;
    private String receiverPhoneNumber;
    private String first_name;
    private String second_name;
    private String patronymic_name;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPatronymic_name() {
        return patronymic_name;
    }

    public void setPatronymic_name(String patronymic_name) {
        this.patronymic_name = patronymic_name;
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
}
