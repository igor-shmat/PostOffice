package postoffice.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Office {
    private Long officeId;
    private String description;

    public Office(Long officeId, String description) {
        this.officeId = officeId;
        this.description = description;
    }

    public Office() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return officeId.equals(office.officeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeId);
    }
}
