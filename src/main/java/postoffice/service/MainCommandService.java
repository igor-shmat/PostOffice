package postoffice.service;

import postoffice.converter.FileToOfficeConverter;
import postoffice.converter.FileToSendingParcelConverter;
import postoffice.converter.FileToUserConverter;

import java.util.ArrayList;

public class MainCommandService {

    public void mapCommand(ArrayList<ArrayList<String>> commands) {
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
                        officeService.newOffice(fileToOfficeConverter.convert(commandsList));
                    }

                    case "REGISTRATION" -> {
                        userService.registration(fileToUserConverter.convert(commandsList));
                    }

                    case "CREATE_NEW_PARCEL" -> {
                        sendingParcelService.sending(fileToSendingParcelConverter.convert(commandsList));
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
    }
}

