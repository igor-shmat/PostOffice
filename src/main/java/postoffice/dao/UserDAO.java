package postoffice.dao;

import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements DAO<Users> {
    private final Connection connection;

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
    public ArrayList<Users> read(ArrayList<Users> users) {
        ArrayList<Users> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
            for (Users user : users) {
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPhoneNumber());
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Users us = new Users();
                    us.setUsersId(rs.getLong("users_id"));
                    us.setPhoneNumber(rs.getString("phone_number"));
                    us.setEmail(rs.getString("email"));
                    us.setFirst_name(rs.getString("first_name"));
                    us.setSecond_name(rs.getString("second_name"));
                    us.setPatronymic_name(rs.getString("patronymic_name"));
                    result.add(us);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Users> getAllUsers() {
        ArrayList<Users> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET_ALL.QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Users us = new Users();
                us.setUsersId(rs.getLong("users_id"));
                us.setPhoneNumber(rs.getString("phone_number"));
                us.setEmail(rs.getString("email"));
                us.setFirst_name(rs.getString("first_name"));
                us.setSecond_name(rs.getString("second_name"));
                us.setPatronymic_name(rs.getString("patronymic_name"));
                result.add(us);
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
        GET("SELECT * FROM mono_post.users  WHERE email = (?) or phone_number = (?)"),
        GET_ALL("SELECT * FROM mono_post.users order by users_id"),
        UPDATE("UPDATE mono_post.users SET phone_number = (?) WHERE users_id = (?)"),
        DELETE("DELETE FROM mono_post.users WHERE users_id = (?)");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
