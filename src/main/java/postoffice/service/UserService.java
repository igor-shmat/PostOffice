package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.UserDAO;
import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;


public class UserService {
    public void createNewUser(ArrayList<Users> users) {
        try (Connection connection = ConnectionToDB.connect()) {
            DAO<Users> dao = new UserDAO(connection);
            ArrayList<Users> usersFromDB = dao.read(users);
            for (Users user : usersFromDB) {
                users.removeIf(users1 -> users1.getPhoneNumber().equals(user.getPhoneNumber()) || users1.getEmail().equals(user.getEmail()));
            }
            if (!users.isEmpty()) {
                dao.create(users);
            }
            usersFromDB.forEach(us -> {
                System.out.println("User with this email : " + "->" + us.getEmail() + "<-" + " or this number : " + "->" + us.getPhoneNumber() + "<-" + " already exists!");
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Users> getAllUsers() {
        ArrayList<Users> parcels = null;
        try (Connection connection = ConnectionToDB.connect()) {
            UserDAO dao = new UserDAO(connection);
            parcels = dao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parcels;
    }
}