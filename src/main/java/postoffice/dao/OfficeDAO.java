package postoffice.dao;

import lombok.NonNull;
import postoffice.entity.Office;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class OfficeDAO implements DAO<Office, String> {
    @NonNull
    private Connection connection;

    public OfficeDAO(@NonNull Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Office office) {
        try (PreparedStatement statement = connection.prepareStatement(OfficeDAO.SQLOffice.INSERT.QUERY)) {
            statement.setString(1, office.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Office get(String str) {
        return null;
    }

    @Override
    public void update(Office model) {
    }

    @Override
    public void delete(Office model) {
    }

    enum SQLOffice {
        GET("SELECT u.id, u.login, u.password, r.id AS rol_id, r.role FROM users AS u LEFT JOIN roles AS r ON u.role = r.id WHERE u.login = (?)"),
        INSERT("INSERT INTO mono_post.office (office_id, description) VALUES (DEFAULT, (?))"),
        DELETE("DELETE FROM users WHERE id = (?) AND login = (?) AND password = (?) RETURNING id"),
        UPDATE("UPDATE users SET password = (?) WHERE id = (?) RETURNING id");

        String QUERY;

        SQLOffice(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
