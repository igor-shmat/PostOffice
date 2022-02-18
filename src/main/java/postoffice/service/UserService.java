package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.UserDAO;
import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    public void registration(ArrayList<Users> users) {
        try(Connection connection = ConnectionToDB.connect()) {
            DAO<Users> dao = new UserDAO(connection);
            ArrayList<Users> clearUsers = new ArrayList<>();
            for(Users user:users) {
                if (dao.read(user).getUsersId() == null) {
                    clearUsers.add(user);

                } else
                    System.out.println("User with email : " + "->" + user.getEmail() + "<-" + " already exists!");
            }
            if (!clearUsers.isEmpty()) {
                dao.create(clearUsers);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}