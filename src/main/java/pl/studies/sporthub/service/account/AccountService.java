package pl.studies.sporthub.service.account;

import org.springframework.data.repository.CrudRepository;
import pl.studies.sporthub.model.Account;


public interface AccountService  {

    Long register(AccountDto dto);

    AccountDto load(Long id);


}
