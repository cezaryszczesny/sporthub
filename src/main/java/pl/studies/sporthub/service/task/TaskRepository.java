package pl.studies.sporthub.service.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.Task;

import java.util.Date;
import java.util.List;


@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByOperatorPlayerId(Long idPlayer);

    List<Task> findByOperatorPlayerIdAndFromTime(Long idPlayer, Date fromTime);

    List<Task> findByOperatorPlayerIdAndFromTimeIsBetween(Long idPlayer, Date startFromTime, Date endFromTime);

}
