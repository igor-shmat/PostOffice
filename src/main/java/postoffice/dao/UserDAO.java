package postoffice.dao;

import postoffice.entity.Users;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements DAO<Users> {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ArrayList<Users> users) {
        try (PreparedStatement statement = connection.prepareStatement(UserDAO.SQLUser.INSERT.QUERY)) {
            for (Users user : users) {
                statement.setString(1, user.getFirst_name());
                statement.setString(2, user.getSecond_name());
                statement.setString(3, user.getPatronymic_name());
                statement.setString(4, user.getEmail());
                statement.setString(5, user.getPhoneNumber());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Users read(Users users) {
        Users result = new Users();
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
            statement.setString(1, users.getEmail());
            statement.setString(2, users.getPhoneNumber());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setUsersId(rs.getLong("users_id"));
                result.setPhoneNumber(rs.getString("phone_number"));
                result.setEmail(rs.getString("email"));
                result.setFirst_name(rs.getString("first_name"));
                result.setSecond_name(rs.getString("second_name"));
                result.setPatronymic_name(rs.getString("patronymic_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Users users) {
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.UPDATE.QUERY)) {
            statement.setString(1, users.getPhoneNumber());
            statement.setLong(2, users.getUsersId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Users users) {
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setLong(1, users.getUsersId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    enum SQLUser {
        INSERT("INSERT INTO mono_post.users (users_id, first_name, second_name, patronymic_name, email, phone_number) VALUES (DEFAULT, (?), (?), (?), (?), (?))"),
        GET("SELECT * FROM mono_post.users  WHERE email = (?) and phone_number = (?)"),
        UPDATE("UPDATE mono_post.users SET phone_number = (?) WHERE users_id = (?)"),
        DELETE("DELETE FROM mono_post.users WHERE users_id = (?)");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
