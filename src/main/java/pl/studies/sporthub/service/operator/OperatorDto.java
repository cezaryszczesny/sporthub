package pl.studies.sporthub.service.operator;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import pl.studies.sporthub.service.AbstractDto;


@Data
public class OperatorDto extends AbstractDto {


    private Long id;
    @NotNull
    private Long idAccount;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Boolean isPlayer = Boolean.FALSE;
    private Long idPlayer;
    private Long idCoach;
}
