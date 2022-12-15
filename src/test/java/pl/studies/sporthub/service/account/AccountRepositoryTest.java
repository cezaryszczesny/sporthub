package pl.studies.sporthub.service.account;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.studies.sporthub.model.Account;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DataJpaTest
class AccountRepositoryTest extends AbstractAccountTest {

    @Autowired
    private AccountRepository repo;


    @Test
    public void shouldSaveAccount() {
        //given
        Account testAccount = createTestAccount();
        //when
        Account savedAccount = repo.save(testAccount);

        //then
        assertThat(savedAccount.getId()).isNotNull();
        assertThat(savedAccount.getEmail()).isEqualTo(testAccount.getEmail());
        assertThat(savedAccount.getPassword()).isEqualTo(testAccount.getPassword());
        assertThat(savedAccount.getCreateTime()).isNotNull();
    }


    @Test
    public void shouldThrowExceptionWhenAccountWithoutEmail() {
        Account accountWithoutEmail = createAccountWithoutEmail();
        assertThatThrownBy(() -> repo.save(accountWithoutEmail)).isInstanceOf(ConstraintViolationException.class);
    }


    @Test
    public void shouldThrowExceptionWhenIncorrectEmailFormat() {
        Account wrongEmailAccount = createTestAccount();
        wrongEmailAccount.setEmail("a");
        assertThatThrownBy(() -> repo.save(wrongEmailAccount)).isInstanceOf(ConstraintViolationException.class);
    }


}
