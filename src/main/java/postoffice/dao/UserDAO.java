package postoffice.dao;

import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements DAO<Users, String> {

    public UserDAO(Connection connection) {
    }

    @Override
    public void save(Users users) {
        try (PreparedStatement statement = ConnectionToDB.connect().prepareStatement(UserDAO.SQLUser.INSERT.QUERY)) {
            statement.setString(1, users.getFirst_name());
            statement.setString(2, users.getSecond_name());
            statement.setString(3, users.getPatronymic_name());
            statement.setString(4, users.getEmail());
            statement.setString(5, users.getPhoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Users get(String email) {
        Users result = new Users();
        try (PreparedStatement statement = ConnectionToDB.connect().prepareStatement(SQLUser.GET.QUERY)) {
            statement.setString(1, email);
            final ResultSet rs = statement.executeQuery();
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
        return null;
    }

    @Override
    public void update(Users model) {
    }

    @Override
    public void delete(Users model) {
    }

    enum SQLUser {
        GET("SELECT * FROM users  WHERE email = (?)"),
        INSERT("INSERT INTO mono_post.users (users_id, first_name, second_name, patronymic_name, email, phone_number) VALUES (DEFAULT, (?), (?), (?), (?), (?))"),
        DELETE("DELETE FROM users WHERE fio = (?) AND email = (?)"),
        UPDATE("UPDATE users SET password = (?) WHERE id = (?) RETURNING id");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
