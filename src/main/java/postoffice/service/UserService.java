package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.UserDAO;
import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    public void registration(Users users) {
        try(Connection connection = ConnectionToDB.connect()) {
            DAO<Users> dao = new UserDAO(connection);
            if (dao.read(users).getUsersId() == null) {
                dao.create(users);
                connection.close();
                System.out.println("User : " + "->" + users.getEmail() +  "<-" + " successfully registered!");
            } else
                System.out.println("User with email : " + "->" + users.getEmail() + "<-" + " already exists!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}