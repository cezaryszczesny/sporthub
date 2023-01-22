package pl.studies.sporthub.service.account;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.exception.AuthenticationException;
import pl.studies.sporthub.model.Account;

import java.util.Optional;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public Long add(AccountDto dto) {
        managePassword(dto);
        Account account = new Account();
        account.apply(dto);
        Account registeredAccount = accountRepository.save(account);
        return registeredAccount.getId();
    }


    private void managePassword(AccountDto dto) {
        String password = dto.getPassword();
        if (password.length() < 8) {
            throw new AuthenticationException("Za krótkie hasło");
        }
        String encodedPassword = passwordEncoder.encode(password);
        dto.setPassword(encodedPassword);
    }


    @Override
    public AccountDto load(Long id) {
        Optional<Account> load = accountRepository.findById(id);
        if (load.isPresent()) {
            Account account = load.get();
            return account.createDto();
        } else {
            throw new ObjectNotFoundException(Account.class.getName(), id);
        }

    }


    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }


    @Override
    public void update(AccountDto dto) {

    }


    @Override
    public AccountDto findByEmail(String email) {
        Account account = accountRepository.findByEmail(email);
        return account != null ? account.createDto() : null;
    }
}
