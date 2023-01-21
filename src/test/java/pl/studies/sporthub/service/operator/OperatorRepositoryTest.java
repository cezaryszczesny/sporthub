package pl.studies.sporthub.service.operator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.studies.sporthub.constance.ConstTest;
import pl.studies.sporthub.model.Account;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.service.account.AccountRepository;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class OperatorRepositoryTest extends AbstractOperatorTest {

    @Autowired
    private OperatorRepository repo;
    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void shouldSaveOperator() {
        Account savedAccount = accountRepository.save(createTestAccount());
        Operator operator = createMockOperator();
        Operator savedOperator = repo.save(operator);
        assertThat(savedOperator.getId()).isNotNull();
    }


    protected Account createTestAccount() {
        Account account = new Account();
        account.setEmail(ConstTest.EMAIL);
        account.setPassword(ConstTest.PASSWORD);
        return account;
    }
}
