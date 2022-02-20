package postoffice.service;

import postoffice.converter.Convertor;
import postoffice.converter.FileToOfficeConverter;
import postoffice.converter.FileToSendingParcelConverter;
import postoffice.converter.FileToUserConverter;
import postoffice.entity.Office;
import postoffice.entity.SendingParcel;
import postoffice.entity.Users;

import java.util.ArrayList;

public class MainCommandService {

    public void mapCommand(ArrayList<ArrayList<String>> commands) {
        ArrayList<SendingParcel> parcelsList = new ArrayList<>();
        ArrayList<Users> usersList = new ArrayList<>();
        ArrayList<Office> officesList = new ArrayList<>();
        ArrayList<ArrayList<String>> usersRegistrationList = new ArrayList<>();
        ArrayList<ArrayList<String>> parcelsRegistrationList = new ArrayList<>();
        ArrayList<ArrayList<String>> officeRegistrationList = new ArrayList<>();
        Convertor<Users> users = new FileToUserConverter();
        Convertor<Office> offices = new FileToOfficeConverter();
        Convertor<SendingParcel> parcels = new FileToSendingParcelConverter();
        SendingParcelService sendingParcelService = new SendingParcelService();
        UserService userService = new UserService();
        OfficeService officeService = new OfficeService();
        for (ArrayList<String> commandsList : commands) {
            for (int i = 0; i < commandsList.size(); i++) {
                String command = commandsList.get(i);
                switch (command) {

                    case "CREATE_NEW_OFFICE" -> {
                        officeRegistrationList.add(commandsList);
                    }

                    case "CREATE_NEW_USER" -> {
                        usersRegistrationList.add(commandsList);
                    }

                    case "CREATE_NEW_PARCEL" -> {
                        parcelsRegistrationList.add(commandsList);
                    }

                    case "GET_ALL_PARCELS" -> {
                        parcelsList.addAll(sendingParcelService.getAllParcels());
                    }

                    case "GET_ALL_USERS" -> {
                        usersList.addAll(userService.getAllUsers());
                    }

                    case "GET_ALL_OFFICES" ->{
                        officesList.addAll(officeService.getAllOffices());
                    }

                    default -> {
                        System.out.println("_____________________________________________________________________________________________________");
                        System.out.println("COMMAND: " + "->" + command + "<-" + " DOES NOT EXIST!!!");
                        System.out.println("DATA:" + commandsList + "WAS NOT PROCESSED!!!");
                        System.out.println("_____________________________________________________________________________________________________");
                    }
                }
                break;
            }
        }
        userService.createNewUser(users.convert(usersRegistrationList));
        officeService.createNewOffice(offices.convert(officeRegistrationList));
        sendingParcelService.createNewParcels(parcels.convert(parcelsRegistrationList));
        parcelsList.forEach(System.out::println);
        usersList.forEach(System.out::println);
        officesList.forEach(System.out::println);
    }
}

