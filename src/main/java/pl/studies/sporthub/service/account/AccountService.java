package pl.studies.sporthub.service.account;

import org.springframework.data.repository.CrudRepository;
import pl.studies.sporthub.model.Account;


public interface AccountService  {

    void register(AccountDto dto);


}
