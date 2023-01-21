package pl.studies.sporthub.service.previousSeasonStats;

import lombok.Data;
import pl.studies.sporthub.service.AbstractDto;


@Data
public class PreviousSeasonStatsDto extends AbstractDto {

    private Long id;

    private Long idPlayer;
    private Integer goals;
    private Integer assists;
    private Integer redCards;
    private Integer yellowCards;
}
