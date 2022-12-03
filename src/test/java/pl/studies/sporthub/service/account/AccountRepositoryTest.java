package pl.studies.sporthub.service.account;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.studies.sporthub.constance.ConstTest;
import pl.studies.sporthub.model.Account;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
 class AccountRepositoryTest {

    @Autowired
    private AccountRepository repo;

    @Test
    public void shouldSaveAccount(){
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
    public void shouldThrowExceptionWhenAccountWithoutEmail(){
        Account accountWithoutEmail = createAccountWithoutEmail();
        assertThatThrownBy(() ->{
            repo.save(accountWithoutEmail);
        }).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    public void shouldThrowExceptionWhenIncorrectEmailFormat(){
        Account wrongEmailAccount = createTestAccount();
        wrongEmailAccount.setEmail("a");
        assertThatThrownBy(() ->{
            repo.save(wrongEmailAccount);
        }).isInstanceOf(ConstraintViolationException.class);
    }


    private Account createTestAccount(){
        Account account = new Account();
        account.setEmail(ConstTest.EMAIL);
        account.setPassword(ConstTest.PASSWORD);
        return account;
    }

    private Account createAccountWithoutEmail(){
        Account account = new Account();
        account.setPassword(ConstTest.PASSWORD);
        return account;
    }
}
