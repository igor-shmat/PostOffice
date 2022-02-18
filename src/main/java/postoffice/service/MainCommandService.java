package postoffice.service;

import postoffice.converter.FileToOfficeConverter;
import postoffice.converter.FileToSendingParcelConverter;
import postoffice.converter.FileToUserConverter;

import java.util.ArrayList;

public class MainCommandService {

    public void mapCommand(ArrayList<ArrayList<String>> commands) {
        ArrayList<ArrayList<String>> usersRegistrationList = new ArrayList<>();
        ArrayList<ArrayList<String>> parcelsRegistrationList = new ArrayList<>();
        ArrayList<ArrayList<String>> officeRegistrationList = new ArrayList<>();
        FileToUserConverter fileToUserConverter = new FileToUserConverter();
        FileToOfficeConverter fileToOfficeConverter = new FileToOfficeConverter();
        FileToSendingParcelConverter fileToSendingParcelConverter = new FileToSendingParcelConverter();
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
        userService.registration(fileToUserConverter.convert(usersRegistrationList));
        officeService.newOffice(fileToOfficeConverter.convert(officeRegistrationList));
        sendingParcelService.sending(fileToSendingParcelConverter.convert(parcelsRegistrationList));
    }
}

