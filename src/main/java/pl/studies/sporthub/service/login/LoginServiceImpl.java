package pl.studies.sporthub.service.login;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.controller.AuthAO;
import pl.studies.sporthub.exception.AuthenticationException;
import pl.studies.sporthub.service.account.AccountDto;
import pl.studies.sporthub.service.account.AccountService;


@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private AccountService accountService;
    private PasswordEncoder passwordEncoder;


    @Override
    public void checkCredentials(AuthAO authAO) {
        AccountDto account = accountService.findByEmail(authAO.getUsername());
        if (account != null) {
            validatePassword(authAO, account);
        } else {
            throw new AuthenticationException("Konto o podanym adresie email nie istnieje");
        }
    }


    private void validatePassword(AuthAO authAO, AccountDto account) {
        if (!passwordEncoder.matches(authAO.getPassword(), account.getPassword())) {
            throw new AuthenticationException("Niepoprawne hasło");
        }
    }
}
