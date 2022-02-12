package postoffice.converter;

import postoffice.entity.SendingParcel;
import postoffice.entity.Users;

import java.util.ArrayList;

public class FileToSendingParcel {
    public SendingParcel convert(ArrayList<String> commandsList) {
        SendingParcel parcel = new SendingParcel();
        return parcel;
    }
}
