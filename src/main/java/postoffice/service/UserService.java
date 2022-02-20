package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.UserDAO;
import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    public void createNewUser(ArrayList<Users> users) {
        try (Connection connection = ConnectionToDB.connect()) {
            DAO<Users> dao = new UserDAO(connection);
            ArrayList<Users> uniqueUsers = new ArrayList<>();
            ArrayList<Users> usersFromDB = dao.read(users);
            if (usersFromDB.isEmpty()) {
                dao.create(users);
            } else {
                ListIterator<Users> lstr = users.listIterator();
                while (lstr.hasNext()) {
                    Users nextUser = lstr.next();
                    if (usersFromDB.contains(nextUser)) {
                        System.out.println("User with email : " + "->" + nextUser.getEmail() + "<-" + " already exists!");
                        lstr.remove();
                    } else {
                        uniqueUsers.add(nextUser);
                    }
                }
                if (!uniqueUsers.isEmpty()) {
                    dao.create(uniqueUsers);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}