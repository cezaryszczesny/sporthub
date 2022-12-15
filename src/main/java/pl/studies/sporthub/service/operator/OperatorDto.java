package pl.studies.sporthub.service.operator;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class OperatorDto {


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
