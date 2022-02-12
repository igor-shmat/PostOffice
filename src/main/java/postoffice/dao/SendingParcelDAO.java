//package postoffice.dao;
//
//import postoffice.entity.SendingParcel;
//import postoffice.entity.Users;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class SendingParcelDAO implements DAO<SendingParcel>{
//
//
//    @Override
//    public void create(SendingParcel parcel) {
//        try (PreparedStatement statement = ConnectionToDB.connect().prepareStatement(UserDAO.SQLUser.INSERT.QUERY)) {
//            statement.setString(1, parcel.getFirst_name());
//            statement.setString(2, parcel.getSecond_name());
//            statement.setString(3, parcel.getPatronymic_name());
//            statement.setString(4, parcel.getEmail());
//            statement.setString(5, parcel.getPhoneNumber());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public SendingParcel read(SendingParcel parcel) {
//        Users result = new Users();
//        try (PreparedStatement statement = ConnectionToDB.connect().prepareStatement(UserDAO.SQLUser.GET.QUERY)) {
//            statement.setString(1, users.getEmail());
//            statement.setString(2, users.getPhoneNumber());
//            final ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                result.setUsersId(rs.getLong("users_id"));
//                result.setPhoneNumber(rs.getString("phone_number"));
//                result.setEmail(rs.getString("email"));
//                result.setFirst_name(rs.getString("first_name"));
//                result.setSecond_name(rs.getString("second_name"));
//                result.setPatronymic_name(rs.getString("patronymic_name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    @Override
//    public void update(Users users) {
//        try (PreparedStatement statement = ConnectionToDB.connect().prepareStatement(UserDAO.SQLUser.UPDATE.QUERY)) {
//            statement.setString(1, users.getPhoneNumber());
//            statement.setLong(2, users.getUsersId());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(Users users) {
//        try (PreparedStatement statement = ConnectionToDB.connect().prepareStatement(UserDAO.SQLUser.DELETE.QUERY)) {
//            statement.setLong(1, users.getUsersId());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    enum SQLUser {
//        INSERT("INSERT INTO mono_post.users (users_id, first_name, second_name, patronymic_name, email, phone_number) VALUES (DEFAULT, (?), (?), (?), (?), (?))"),
//        GET("SELECT * FROM mono_post.users  WHERE email = (?) and phone_number = (?)"),
//        UPDATE("UPDATE mono_post.users SET phone_number = (?) WHERE users_id = (?)"),
//        DELETE("DELETE FROM mono_post.users WHERE users_id = (?)");
//
//        String QUERY;
//
//        SQLUser(String QUERY) {
//            this.QUERY = QUERY;
//        }
//    }
//
//}
