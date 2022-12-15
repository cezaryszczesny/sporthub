package pl.studies.sporthub.service.account;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private Long idOperator;
    private String email;
    private String password;


    public AccountDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
