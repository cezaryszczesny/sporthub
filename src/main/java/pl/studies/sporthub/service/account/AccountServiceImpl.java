package pl.studies.sporthub.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.model.Account;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public void register(AccountDto dto) {
        Account account = new Account();
        account.apply(dto);
        accountRepository.save(account);
    }
}
