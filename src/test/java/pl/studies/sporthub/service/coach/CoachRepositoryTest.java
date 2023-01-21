package pl.studies.sporthub.service.coach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.studies.sporthub.model.Account;
import pl.studies.sporthub.model.Coach;
import pl.studies.sporthub.model.CoachSpecialty;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.service.account.AccountRepository;
import pl.studies.sporthub.service.operator.OperatorRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class CoachRepositoryTest extends AbstractCoachTest {

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

}
