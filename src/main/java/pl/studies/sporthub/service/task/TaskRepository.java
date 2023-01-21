package pl.studies.sporthub.service.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.Task;


@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
