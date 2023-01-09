package pl.studies.sporthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import pl.studies.sporthub.service.SimpleRowDto;


@Entity
@NoArgsConstructor
public class PlayerStatus extends SimpleRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String name;


    public SimpleRowDto createDto() {
        return createDto(id, name);
    }
}
