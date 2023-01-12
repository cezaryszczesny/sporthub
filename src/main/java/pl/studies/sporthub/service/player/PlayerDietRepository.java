package pl.studies.sporthub.service.player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.PlayerDiet;


@Repository
public interface PlayerDietRepository extends CrudRepository<PlayerDiet, Long> {

}
