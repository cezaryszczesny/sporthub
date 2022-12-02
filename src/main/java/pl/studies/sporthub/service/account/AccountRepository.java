package pl.studies.sporthub.service.account;

import org.springframework.data.repository.CrudRepository;
import pl.studies.sporthub.model.Account;


public interface AccountRepository extends CrudRepository<Account, Long> {

}
