package postoffice.service;

import postoffice.dao.DAO;
import postoffice.dao.UserDAO;
import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserService {
    public void registration(Users users) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
            DAO<Users, String> dao = new UserDAO(connection);
            dao.save(users);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}