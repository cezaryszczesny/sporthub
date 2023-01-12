package pl.studies.sporthub.service.coach;

import lombok.Data;
import pl.studies.sporthub.service.AbstractDto;


@Data
public class CoachDto extends AbstractDto {

    private Long id;
    private Long idOperator;
    private Long idSpecialty;
    private boolean isActive;
}
