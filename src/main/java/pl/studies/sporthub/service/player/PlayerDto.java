package pl.studies.sporthub.service.player;

import lombok.Data;
import pl.studies.sporthub.service.AbstractDto;
import pl.studies.sporthub.service.SimpleRowDto;

import java.util.Date;


@Data
public class PlayerDto extends AbstractDto {

    private Long id;
    private Long idOperator;
    private SimpleRowDto playerPosition;
    private Date birthDate;
    private Integer height;
    private Integer weight;
    private String teamName;
    private SimpleRowDto foot;
    private SimpleRowDto status;
    private SimpleRowDto diet;

}
