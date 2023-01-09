package pl.studies.sporthub.service.coach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.studies.sporthub.constance.ConstTest;
import pl.studies.sporthub.model.Account;
import pl.studies.sporthub.model.Coach;
import pl.studies.sporthub.model.CoachSpecialty;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.service.account.AccountRepository;
import pl.studies.sporthub.service.operator.OperatorRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class CoachRepositoryTest {

    @Autowired
    private CoachRepository repo;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private CoachSpecialtyRepository coachSpecialtyRepository;
    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void shouldSaveCoach() {
        //given
        Coach coach = new Coach();
        Account testAccount = createTestAccount();
        accountRepository.save(testAccount);
        Operator operator = createMockOperator();
        operatorRepository.save(operator);
        coach.setOperator(operator);
        Optional<CoachSpecialty> byId = coachSpecialtyRepository.findById(1L);
        coach.setSpecialty(byId.get());
        coach.setIsActive(Boolean.FALSE);
        //when
        Coach save = repo.save(coach);
        //then
        assertThat(save.getId()).isNotNull();
        assertThat(save.getIsActive()).isEqualTo(coach.getIsActive());
        assertThat(save.getOperator().getId()).isEqualTo(coach.getOperator().getId());
        assertThat(save.getSpecialty().getId()).isEqualTo(coach.getSpecialty().getId());
        assertThat(save.getSpecialty().getName()).isEqualTo("Atak");
    }


    protected Operator createMockOperator() {
        Operator operator = new Operator();
        operator.setFirstName(ConstTest.FIRST_NAME);
        operator.setLastName(ConstTest.LAST_NAME);
        operator.setIsPlayer(Boolean.FALSE);
        Account account = new Account();
        account.setId(ConstTest.ID_ACCOUNT);
        operator.setAccount(account);

        return operator;
    }


    protected Account createTestAccount() {
        Account account = new Account();
        account.setEmail(ConstTest.EMAIL);
        account.setPassword(ConstTest.PASSWORD);
        return account;
    }
}
