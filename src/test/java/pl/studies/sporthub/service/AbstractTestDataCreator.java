package pl.studies.sporthub.service;

import pl.studies.sporthub.constance.ConstTest;
import pl.studies.sporthub.model.Account;
import pl.studies.sporthub.model.Coach;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.model.Player;
import pl.studies.sporthub.service.account.AccountDto;
import pl.studies.sporthub.service.operator.OperatorDto;

import java.util.Date;


public class AbstractTestDataCreator {


    protected Account createTestAccount() {
        Account account = new Account();
        account.setEmail(ConstTest.EMAIL);
        account.setPassword(ConstTest.PASSWORD);
        return account;
    }


    protected Account createAccountWithoutEmail() {
        Account account = new Account();
        account.setPassword(ConstTest.PASSWORD);
        return account;
    }


    protected AccountDto createTestAccountDto() {
        AccountDto accountDto = new AccountDto(
                ConstTest.EMAIL,
                ConstTest.PASSWORD
        );
        return accountDto;
    }


    protected Account createMockAccount() {
        Account account = new Account();
        account.setId(1L);
        account.setEmail(ConstTest.EMAIL);
        account.setPassword(ConstTest.PASSWORD);
        account.setCreateTime(new Date());
        return account;
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
