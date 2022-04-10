package postoffice.converter;

import postoffice.dto.SendingParcels;
import postoffice.entity.Office;
import postoffice.entity.SendingParcel;
import postoffice.entity.Users;
import postoffice.enums.ParcelStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SendingParcelConverter implements Convertor<SendingParcel> {

    @Override
    public ArrayList<SendingParcel> convertToEntity(ArrayList<ArrayList<String>> parcelsRegistrationList) {
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

    public ArrayList<SendingParcels> convertToDTO(ArrayList<SendingParcel> sendingParcel){
        ArrayList<SendingParcels> parcelsToView = new ArrayList<>();
        for (SendingParcel parcel : sendingParcel){
            SendingParcels sendingParcels = new SendingParcels();
            sendingParcels.setParcelId(parcel.getParcelId());
            sendingParcels.setParcelStatus(parcel.getParcelStatus());
            sendingParcels.setCreateDate(parcel.getCreateDate());
            sendingParcels.setSenderOffice(parcel.getSenderOffice().getOfficeId().toString());
            sendingParcels.setReceiverOffice(parcel.getReceiverOffice().getOfficeId().toString());
            sendingParcels.setUsers(parcel.getUsers().getUsersId().toString());
            sendingParcels.setReceiver_first_name(parcel.getReceiver_first_name());
            sendingParcels.setReceiver_second_name(parcel.getReceiver_second_name());
            sendingParcels.setReceiver_patronymic_name(parcel.getReceiver_patronymic_name());
            sendingParcels.setReceiverPhoneNumber(parcel.getReceiverPhoneNumber());
            sendingParcels.setUpdateStatus(parcel.getUpdateStatus());
            parcelsToView.add(sendingParcels);
        }
        return parcelsToView;
    }
}
