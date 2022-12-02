package pl.studies.sporthub.model;

import lombok.*;


/**
 * Prosty obiekt wiersza z bazy
 */
@Data
public class AbstractSimpleRow {

    protected Long id;
    protected String name;
}
