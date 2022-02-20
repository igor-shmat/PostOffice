package postoffice.converter;

import postoffice.entity.Office;
import postoffice.entity.SendingParcel;
import postoffice.entity.Users;
import postoffice.enums.ParcelStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FileToSendingParcelConverter implements Convertor<SendingParcel> {

    @Override
    public ArrayList<SendingParcel> convert(ArrayList<ArrayList<String>> parcelsRegistrationList) {
        ArrayList<SendingParcel> parcels = new ArrayList<>();
        for (ArrayList<String> commandList : parcelsRegistrationList) {
            SendingParcel parcel = new SendingParcel();
            Users users = new Users();
            Office officeSender = new Office();
            Office officeReceiver = new Office();
            users.setUsersId(Long.parseLong(commandList.get(1)));
            parcel.setUsers(users);
            officeSender.setOfficeId(Long.parseLong(commandList.get(2)));
            parcel.setSenderOffice(officeSender);
            officeReceiver.setOfficeId(Long.parseLong(commandList.get(3)));
            parcel.setReceiverOffice(officeReceiver);
            parcel.setReceiverPhoneNumber(commandList.get(4));
            parcel.setReceiver_first_name(commandList.get(5));
            parcel.setReceiver_second_name(commandList.get(6));
            parcel.setReceiver_patronymic_name(commandList.get(7));
            parcel.setParcelStatus(ParcelStatus.NEW);
            parcel.setCreateDate(LocalDateTime.now());
            parcel.setUpdateStatus(LocalDateTime.now());
            parcels.add(parcel);
        }
        return parcels;
    }
}
