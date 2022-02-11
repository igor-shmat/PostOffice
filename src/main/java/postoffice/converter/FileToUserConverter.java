package postoffice.converter;

import postoffice.entity.Users;

import java.util.ArrayList;

public class FileToUserConverter {
    public Users convert(ArrayList<String> commandsList) {
        Users users = new Users();
        users.setFirst_name(commandsList.get(1));
        users.setSecond_name(commandsList.get(2));
        users.setPatronymic_name(commandsList.get(3));
        users.setPhoneNumber(commandsList.get(4));
        users.setEmail(commandsList.get(5));
        return users;
    }
}
