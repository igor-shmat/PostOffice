package postoffice.converter;

import postoffice.entity.Users;

import java.util.ArrayList;

public class FileToUserConverter {
    public ArrayList<Users> convert(ArrayList<ArrayList<String>> usersRegistrationList) {
        ArrayList<Users> users = new ArrayList<>();
        for (ArrayList<String> commandList : usersRegistrationList) {
            Users user = new Users();
            user.setFirst_name(commandList.get(1));
            user.setSecond_name(commandList.get(2));
            user.setPatronymic_name(commandList.get(3));
            user.setPhoneNumber(commandList.get(4));
            user.setEmail(commandList.get(5));
            users.add(user);
        }
        return users;
    }
}
