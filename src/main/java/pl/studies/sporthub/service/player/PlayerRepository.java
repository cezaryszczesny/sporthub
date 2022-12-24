package pl.studies.sporthub.service.player;

import org.springframework.data.repository.CrudRepository;
import pl.studies.sporthub.model.Player;


public interface PlayerRepository extends CrudRepository<Player, Long> {

}
