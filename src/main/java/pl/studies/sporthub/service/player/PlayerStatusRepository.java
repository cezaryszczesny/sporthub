package pl.studies.sporthub.service.player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.PlayerStatus;


@Repository
public interface PlayerStatusRepository extends CrudRepository<PlayerStatus, Long> {

}
