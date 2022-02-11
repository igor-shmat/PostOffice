package postoffice.service;

import postoffice.dao.ConnectionToDB;
import postoffice.dao.DAO;
import postoffice.dao.UserDAO;
import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    public void registration(Users users) {
        try {
            Connection connection;
            DAO<Users, String> dao = new UserDAO(connection = ConnectionToDB.connect());
            dao.save(users);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}