package pl.studies.sporthub.service.task;

import lombok.Data;
import pl.studies.sporthub.service.AbstractDto;

import java.util.Date;


@Data
public class TaskDto extends AbstractDto {

    private Long id;
    private String description;
    private Long idPlayer;
    private Long idCoach;
    private Long idOperatorCreator;
    private Long idFacility;
    private Date fromTime;
    private Date toTime;
}
