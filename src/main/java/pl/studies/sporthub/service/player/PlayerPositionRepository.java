package pl.studies.sporthub.service.player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.PlayerPosition;


@Repository
public interface PlayerPositionRepository extends CrudRepository<PlayerPosition, Long> {

}
