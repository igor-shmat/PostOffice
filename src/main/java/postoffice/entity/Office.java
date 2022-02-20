package postoffice.entity;

import java.util.Objects;

public class Office {
    private Long officeId;
    private String address;
    private String description;

    public Office() {
    }

    public Office(Long officeId) {
        this.officeId = officeId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return Objects.equals(address, office.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeId=" + officeId +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
