package postoffice.converter;

import postoffice.entity.Users;

import java.util.ArrayList;

public class FileToUserConverter {
    public Users convert(ArrayList<String> commandsList) {
        Users users = new Users();
        users.setFio(commandsList.get(1));
        users.setPhoneNumber(commandsList.get(2));
        users.setEmail(commandsList.get(3));
        return users;
    }
}
