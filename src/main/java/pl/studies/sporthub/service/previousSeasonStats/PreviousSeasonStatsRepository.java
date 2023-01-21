package pl.studies.sporthub.service.previousSeasonStats;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.PreviousSeasonStats;


@Repository
public interface PreviousSeasonStatsRepository extends CrudRepository<PreviousSeasonStats, Long> {


    PreviousSeasonStats findByPlayerId(Long idPlayer);
}
