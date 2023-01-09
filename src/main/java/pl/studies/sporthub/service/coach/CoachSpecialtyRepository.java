package pl.studies.sporthub.service.coach;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.CoachSpecialty;


@Repository
public interface CoachSpecialtyRepository extends CrudRepository<CoachSpecialty, Long> {

}
