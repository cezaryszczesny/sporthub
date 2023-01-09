package pl.studies.sporthub.model;

import lombok.NoArgsConstructor;
import pl.studies.sporthub.service.SimpleRowDto;


/**
 * Prosty obiekt wiersza z bazy
 */
@NoArgsConstructor
public class SimpleRow {

    protected SimpleRowDto createDto(Long id, String label) {
        return new SimpleRowDto(id, label);
    }
}
