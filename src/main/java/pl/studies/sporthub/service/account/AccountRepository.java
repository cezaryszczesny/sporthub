package pl.studies.sporthub.service.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.Account;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByEmail(String email);

}
