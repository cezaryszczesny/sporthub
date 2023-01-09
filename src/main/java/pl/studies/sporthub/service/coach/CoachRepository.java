package pl.studies.sporthub.service.coach;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.Coach;


@Repository
public interface CoachRepository extends CrudRepository<Coach, Long> {

}
