package postoffice.entity;

import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Objects;

@Data
public class Users {
    private Long usersId;
    @NonNull
    private String fio;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;
    private List<SendingParcel> sendingParcels;

    public Users() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return fio.equals(users.fio) && phoneNumber.equals(users.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, phoneNumber);
    }
}
