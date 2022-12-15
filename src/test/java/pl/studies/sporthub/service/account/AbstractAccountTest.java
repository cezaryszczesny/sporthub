package pl.studies.sporthub.service.account;

import pl.studies.sporthub.constance.ConstTest;
import pl.studies.sporthub.model.Account;

import java.util.Date;


public class AbstractAccountTest {

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

}
