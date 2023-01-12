package pl.studies.sporthub.service.player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.PlayerFoot;


@Repository
public interface PlayerFootRepository extends CrudRepository<PlayerFoot, Long> {

}
