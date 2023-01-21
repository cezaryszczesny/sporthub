package pl.studies.sporthub.service.task;

import lombok.Data;
import pl.studies.sporthub.service.AbstractDto;

import java.util.Date;


@Data
public class TaskDto extends AbstractDto {

    private Long id;
    private Long idOperatorPlayer;
    private Long idOperatorCoach;
    private Long idOperatorCreator;
    private Date fromTime;
    private Date toTime;
}
