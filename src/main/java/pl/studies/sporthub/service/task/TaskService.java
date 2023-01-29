package pl.studies.sporthub.service.task;

import pl.studies.sporthub.service.BaseApplicationService;

import java.util.Date;
import java.util.List;


public interface TaskService extends BaseApplicationService<TaskDto> {

    List<TaskDto> findAllByOperatorPlayerId(Long idOperator);

    List<TaskDto> findAllByFromTime(Long idOperator, Date fromTime);

    List<TaskDto> findAllBetweenTime(Long idOperator, Date startDate, Date endDate);

}
