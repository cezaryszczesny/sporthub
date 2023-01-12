package pl.studies.sporthub.service.facility;

import lombok.Data;
import pl.studies.sporthub.service.AbstractDto;


@Data
public class FacilityDto extends AbstractDto {

    private Long id;
    private String name;
    private String trainingRoomNumber;
    private Boolean isOutside;
    private Integer peopleLimit;

}
