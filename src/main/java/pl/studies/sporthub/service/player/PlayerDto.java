package pl.studies.sporthub.service.player;

import lombok.Data;
import pl.studies.sporthub.service.AbstractDto;

import java.util.Date;


@Data
public class PlayerDto extends AbstractDto {

    private Long id;
    private Long idOperator;
    private Long idPlayerPosition;
    private Date birthDate;
    private Integer height;
    private Integer weight;
    private String teamName;
    private Long idFoot;
    private Long idStatus;
    private Long idDiet;
    private Long idPreviousSeasonStats;
}
