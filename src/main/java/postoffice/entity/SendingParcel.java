package postoffice.entity;

import lombok.Data;

import postoffice.enums.ParcelStatus;

import java.util.Date;

@Data
public class SendingParcel {
    private Long parcelId;
    private Users users;
    private Office senderOffice;
    private Office receiverOffice;
    private Integer receiverPhoneNumber;
    private String receiverFio;
    private ParcelStatus parcelStatus;
    private Date createDate;
    private Date updateStatus;

}
