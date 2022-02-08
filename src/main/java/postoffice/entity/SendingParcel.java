package postoffice.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import postoffice.enums.ParcelStatus;

import java.util.Date;

@Setter
@Getter
public class SendingParcel {
    private Long parcelId;
    private Users users;
    private Office senderOffice;
    private Office receiverOffice;
    private Integer receiverPhoneNumber;
    @NonNull
    private String receiverFio;
    private ParcelStatus parcelStatus;
    private Date createDate;
    private Date updateStatus;

    public SendingParcel(Long parcelId, Users users, Office senderOffice, Office receiverOffice,
                         Integer receiverPhoneNumber, @NotNull String receiverFio, ParcelStatus parcelStatus, Date createDate,
                         Date updateStatus) {
        this.parcelId = parcelId;
        this.users = users;
        this.senderOffice = senderOffice;
        this.receiverOffice = receiverOffice;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.receiverFio = receiverFio;
        this.parcelStatus = parcelStatus;
        this.createDate = createDate;
        this.updateStatus = updateStatus;
    }

    public SendingParcel() {
    }
}
