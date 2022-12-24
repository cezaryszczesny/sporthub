package pl.studies.sporthub.service.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.studies.sporthub.service.AbstractDto;


@Data
@NoArgsConstructor
public class AccountDto extends AbstractDto {

    private Long id;
    private Long idOperator;
    private String email;
    private String password;


    public AccountDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
