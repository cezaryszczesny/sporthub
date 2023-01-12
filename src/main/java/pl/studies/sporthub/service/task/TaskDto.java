package pl.studies.sporthub.service.task;

import lombok.Data;
import pl.studies.sporthub.service.AbstractDto;

import java.util.Date;


@Data
public class TaskDto extends AbstractDto {

    private Long id;
    private Long idOperator;
    private String coachFullName;
    private String createdBy;
    private Long idFacility;
    private Date fromTime;
    private Date toTime;
}
