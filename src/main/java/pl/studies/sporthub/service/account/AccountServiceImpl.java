package pl.studies.sporthub.service.account;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.model.Account;

import java.util.Optional;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    public Long register(AccountDto dto) {
        Account account = new Account();
        account.apply(dto);
        Account registeredAccount = accountRepository.save(account);
        return registeredAccount.getId();
    }


    @Override
    public AccountDto load(Long id){
        Optional<Account> load = accountRepository.findById(id);
        if(load.isPresent()){
            Account account = load.get();
            account.setEmail("costam@lksna.com");
            return account.createDto();
        } else{
            throw new ObjectNotFoundException(Account.class.getName(), id);
        }

    }
}
