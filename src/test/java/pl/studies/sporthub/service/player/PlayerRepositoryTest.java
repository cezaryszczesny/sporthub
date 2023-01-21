package pl.studies.sporthub.service.player;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.model.Player;
import pl.studies.sporthub.service.account.AccountRepository;
import pl.studies.sporthub.service.operator.OperatorRepository;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class PlayerRepositoryTest extends AbstractPlayerTest {

    @Autowired
    private PlayerRepository repo;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private PlayerFootRepository playerFootRepository;
    @Autowired
    private PlayerStatusRepository playerStatusRepository;
    @Autowired
    private PlayerDietRepository playerDietRepository;
    @Autowired
    private PlayerPositionRepository playerPositionRepository;


    @Test
    public void shouldAddPlayer() {
        //setup
        accountRepository.save(createTestAccount());
        Operator savedOperator = operatorRepository.save(createMockOperator());
        //given
        Player player = new Player();
        player.setPlayerFoot(playerFootRepository.findById(1L).get());
        player.setPlayerStatus(playerStatusRepository.findById(1L).get());
        player.setPlayerDiet(playerDietRepository.findById(1L).get());
        player.setPlayerPosition(playerPositionRepository.findById(1L).get());
        player.setOperator(savedOperator);
        player.setHeight(167);
        player.setWeight(55);

        player.setBirthDate(Calendar.getInstance().getTime());
        player.setTeamName("Śląsk Wroclaw");
        Player save = repo.save(player);
        assertThat(save.getId()).isNotNull();
    }
}
