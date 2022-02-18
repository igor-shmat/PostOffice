package postoffice.converter;

import postoffice.entity.Office;
import postoffice.entity.SendingParcel;
import postoffice.entity.Users;
import postoffice.enums.ParcelStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FileToSendingParcelConverter {
    public SendingParcel convert(ArrayList<String> commandsList) {
        SendingParcel parcel = new SendingParcel();
        Users users = new Users();
        Office officeSender = new Office();
        Office officeReceiver = new Office();
        users.setUsersId(Long.parseLong(commandsList.get(1)));
        parcel.setUsers(users);
        officeSender.setOfficeId(Long.parseLong(commandsList.get(2)));
        parcel.setSenderOffice(officeSender);
        officeReceiver.setOfficeId(Long.parseLong(commandsList.get(3)));
        parcel.setReceiverOffice(officeReceiver);
        parcel.setReceiverPhoneNumber(commandsList.get(4));
        parcel.setReceiver_first_name(commandsList.get(5));
        parcel.setReceiver_second_name(commandsList.get(6));
        parcel.setReceiver_patronymic_name(commandsList.get(7));
        parcel.setParcelStatus(ParcelStatus.NEW);
        parcel.setCreateDate(LocalDateTime.now());
        parcel.setUpdateStatus(LocalDateTime.now());
        return parcel;
    }
}
