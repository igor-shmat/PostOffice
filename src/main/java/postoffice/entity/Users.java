package postoffice.entity;

import java.util.Objects;

public class Users {
    private Long usersId;
    private String first_name;
    private String second_name;
    private String patronymic_name;
    private String phoneNumber;
    private String email;

    public Users() {
    }

    public Users(Long usersId) {
        this.usersId = usersId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPatronymic_name() {
        return patronymic_name;
    }

    public void setPatronymic_name(String patronymic_name) {
        this.patronymic_name = patronymic_name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(phoneNumber, users1.phoneNumber) && Objects.equals(email, users1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersId=" + usersId +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", patronymic_name='" + patronymic_name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
