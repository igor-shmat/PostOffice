package postoffice.dao;

import postoffice.entity.Office;
import postoffice.entity.SendingParcel;
import postoffice.entity.Users;
import postoffice.enums.ParcelStatus;

import java.sql.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SendingParcelDAO implements DAO<SendingParcel> {
    private Connection connection;

    public SendingParcelDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(ArrayList<SendingParcel> parcels) {
        try (PreparedStatement statement = connection.prepareStatement(SendingParcelDAO.SQLParcel.INSERT.QUERY)) {
            for (SendingParcel parcel : parcels) {
                statement.setLong(1, parcel.getUsers().getUsersId());
                statement.setLong(2, parcel.getSenderOffice().getOfficeId());
                statement.setLong(3, parcel.getReceiverOffice().getOfficeId());
                statement.setString(4, parcel.getReceiverPhoneNumber());
                statement.setString(5, parcel.getReceiver_first_name());
                statement.setString(6, parcel.getReceiver_second_name());
                statement.setString(7, parcel.getReceiver_patronymic_name());
                statement.setString(8, parcel.getParcelStatus().toString());
                statement.setTimestamp(9, Timestamp.valueOf(parcel.getCreateDate()));
                statement.setTimestamp(10, Timestamp.valueOf(parcel.getUpdateStatus()));
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public SendingParcel read(SendingParcel parcel) {
        SendingParcel result = new SendingParcel();
        try (PreparedStatement statement = connection.prepareStatement(SendingParcelDAO.SQLParcel.GET.QUERY)) {
            statement.setLong(1, parcel.getParcelId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setParcelId(rs.getLong("parcel_id"));
                result.setUsers(new Users(rs.getLong("users_id")));
                result.setSenderOffice(new Office(rs.getLong("sender_office_id")));
                result.setReceiverOffice(new Office(rs.getLong("receiver_office_id")));
                result.setReceiverPhoneNumber(rs.getString("receiver_phone_number"));
                result.setReceiver_first_name(rs.getString("receiver_first_name"));
                result.setReceiver_second_name(rs.getString("receiver_second_name"));
                result.setReceiver_patronymic_name(rs.getString("receiver_patronymic_name"));
                result.setParcelStatus(ParcelStatus.valueOf(rs.getString("parcel_status")));
                result.setCreateDate(rs.getTimestamp("create_date").toLocalDateTime());
                result.setUpdateStatus(rs.getTimestamp("update_status").toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(SendingParcel parcel) {
    }

    @Override
    public void delete(SendingParcel parcel) {
    }

    public List<SendingParcel> getNewParcels() {
        List<SendingParcel> parcelList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQLParcel.GET.QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                SendingParcel result = new SendingParcel();
                result.setParcelId(rs.getLong("parcel_id"));
                result.setUsers(new Users(rs.getLong("users_id")));
                result.setSenderOffice(new Office(rs.getLong("sender_office_id")));
                result.setReceiverOffice(new Office(rs.getLong("receiver_office_id")));
                result.setReceiverPhoneNumber(rs.getString("receiver_phone_number"));
                result.setReceiver_first_name(rs.getString("receiver_first_name"));
                result.setReceiver_second_name(rs.getString("receiver_second_name"));
                result.setReceiver_patronymic_name(rs.getString("receiver_patronymic_name"));
                result.setParcelStatus(ParcelStatus.valueOf(rs.getString("parcel_status")));
                result.setCreateDate(rs.getTimestamp("create_date").toLocalDateTime());
                result.setUpdateStatus(rs.getTimestamp("update_status").toLocalDateTime());
                parcelList.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parcelList;
    }

    public void batchUpdate(ArrayList<SendingParcel> parcels) {
        try (PreparedStatement statement = connection.prepareStatement(SendingParcelDAO.SQLParcel.UPDATE.QUERY)) {
            for (SendingParcel parcel : parcels) {

                statement.setString(1, String.valueOf(parcel.getParcelStatus()));
                statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                statement.setLong(3, parcel.getParcelId());

                statement.addBatch();
            }
            statement.executeBatch();
            System.out.println("batch");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    enum SQLParcel {
        INSERT("INSERT INTO mono_post.sending_parcel (parcel_id, users_id, sender_office_id, receiver_office_id, receiver_phone_number, receiver_first_name, receiver_second_name, receiver_patronymic_name, parcel_status, create_date, update_status) VALUES (DEFAULT, (?), (?), (?), (?), (?), (?), (?), (?), (?), (?))"),
        GET("SELECT * FROM mono_post.sending_parcel  WHERE parcel_status = 'NEW'"),
        UPDATE("UPDATE mono_post.sending_parcel SET parcel_status = (?), update_status = (?) WHERE parcel_status = 'NEW' and parcel_id = (?)"),
        DELETE("DELETE FROM mono_post.sending_parcel WHERE users_id = (?)");

        String QUERY;

        SQLParcel(String QUERY) {
            this.QUERY = QUERY;
        }
    }

}
