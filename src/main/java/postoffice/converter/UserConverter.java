package postoffice.converter;

import postoffice.entity.Users;

import java.util.ArrayList;

public class UserConverter implements Convertor<Users> {

    @Override
    public ArrayList<Users> convertToEntity(ArrayList<ArrayList<String>> commandsList) {
        ArrayList<Users> users = new ArrayList<>();
        for (ArrayList<String> commandList : commandsList) {
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
