package postoffice.entity;

import lombok.Data;

@Data
public class Office {
    private Long officeId;
    private String description;

    public Office() {
    }
}
