package pl.studies.sporthub.service.facility;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.Facility;


@Repository
public interface FacilityRepository extends CrudRepository<Facility, Long> {

}
