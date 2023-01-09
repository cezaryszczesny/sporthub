package pl.studies.sporthub.service.operator;

import pl.studies.sporthub.constance.ConstTest;
import pl.studies.sporthub.model.Account;
import pl.studies.sporthub.model.Coach;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.model.Player;


public class AbstractOperatorTest {


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


    protected Operator createMockPlayerOperator() {
        Operator operator = createMockOperator();
        operator.setIsPlayer(Boolean.TRUE);
        Player player = new Player();
        player.setId(ConstTest.ID_PLAYER);
        operator.setPlayer(player);

        return operator;
    }


    protected Operator createMockCoachOperator() {
        Operator operator = createMockOperator();
        Coach coach = new Coach();
        coach.setId(ConstTest.ID_COACH);
        operator.setCoach(coach);

        return operator;
    }


    protected OperatorDto createSimpleOperatorDto() {
        OperatorDto dto = new OperatorDto();
        dto.setIdAccount(ConstTest.ID_ACCOUNT);
        dto.setFirstName(ConstTest.FIRST_NAME);
        dto.setLastName(ConstTest.LAST_NAME);

        return dto;
    }
}
