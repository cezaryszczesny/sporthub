package pl.studies.sporthub.service.previousSeasonStats;

import pl.studies.sporthub.service.BaseApplicationService;


public interface PreviousSeasonStatsService extends BaseApplicationService<PreviousSeasonStatsDto> {

    PreviousSeasonStatsDto findByPlayerId(Long idPlayer);
}
