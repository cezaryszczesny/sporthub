package pl.studies.sporthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String trainingRoomNumber;

    @NotNull
    private Boolean isOutside;

    private Integer peopleLimit;

}
