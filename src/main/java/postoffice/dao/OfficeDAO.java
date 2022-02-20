package postoffice.dao;

import postoffice.entity.Office;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OfficeDAO implements DAO<Office> {
    private final Connection connection;

    public OfficeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ArrayList<Office> offices) {
        try (PreparedStatement statement = connection.prepareStatement(OfficeDAO.SQLOffice.INSERT.QUERY)) {
            for (Office office : offices) {
                statement.setString(1, office.getAddress());
                statement.setString(2, office.getDescription());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Office> read(ArrayList<Office> offices) {
        ArrayList<Office> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(OfficeDAO.SQLOffice.GET.QUERY)) {
            for (Office office : offices) {
                statement.setString(1, office.getAddress());
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Office off = new Office();
                    off.setOfficeId(rs.getLong("office_id"));
                    off.setAddress(rs.getString("address"));
                    off.setDescription(rs.getString("description"));
                    result.add(off);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Office> getAllOffices() {
        ArrayList<Office> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLOffice.GET_ALL.QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Office off = new Office();
                off.setOfficeId(rs.getLong("office_id"));
                off.setAddress(rs.getString("address"));
                off.setDescription(rs.getString("description"));
                result.add(off);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Office office) {
        try (PreparedStatement statement = connection.prepareStatement(OfficeDAO.SQLOffice.UPDATE.QUERY)) {
            statement.setString(1, office.getDescription());
            statement.setLong(2, office.getOfficeId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Office model) {
    }

    enum SQLOffice {
        INSERT("INSERT INTO mono_post.office (office_id, address, description) VALUES (DEFAULT, (?), (?))"),
        GET("SELECT * FROM mono_post.office WHERE address = (?)"),
        GET_ALL("SELECT * FROM mono_post.office order by office_id"),
        UPDATE("UPDATE mono_post.office SET description = (?) WHERE id = (?)"),
        DELETE("DELETE FROM mono_post.office WHERE id = (?) AND login = (?) AND password = (?)");


        String QUERY;

        SQLOffice(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
