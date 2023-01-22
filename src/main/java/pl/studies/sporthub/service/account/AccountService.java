package pl.studies.sporthub.service.account;


import pl.studies.sporthub.service.BaseApplicationService;


public interface AccountService extends BaseApplicationService<AccountDto> {

    AccountDto findByEmail(String email);
}
