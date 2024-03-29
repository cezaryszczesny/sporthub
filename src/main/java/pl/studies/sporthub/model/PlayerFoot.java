package pl.studies.sporthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.studies.sporthub.service.SimpleRowDto;


@Entity
@NoArgsConstructor
@Data
@ToString
public class PlayerFoot extends SimpleRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String name;


    public SimpleRowDto createDto() {
        return createDto(id, name);
    }
}
