package postoffice.dao;

import org.jetbrains.annotations.NotNull;
import postoffice.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements DAO<Users, String> {

    @NotNull
    private Connection connection ;

    public UserDAO(@NotNull Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Users users) {
        try (PreparedStatement statement = connection.prepareStatement(UserDAO.SQLUser.INSERT.QUERY)) {
            statement.setString(1, users.getFio());
            statement.setString(2, users.getEmail());
            statement.setString(3, users.getPhoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Users get(String email) {
        Users result = new Users();
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
            statement.setString(1, email);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setUsersId(rs.getLong("users_id"));
                result.setPhoneNumber(rs.getString("phone_number"));
                result.setEmail(rs.getString("email"));
                result.setFio(rs.getString("fio"));
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
        INSERT("INSERT INTO mono_post.users (users_id, fio, email, phone_number) VALUES (DEFAULT, (?), (?), (?))"),
        DELETE("DELETE FROM users WHERE id = (?) AND login = (?) AND password = (?) RETURNING id"),
        UPDATE("UPDATE users SET password = (?) WHERE id = (?) RETURNING id");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
