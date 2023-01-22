package pl.studies.sporthub.service.account;

import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.studies.sporthub.model.Account;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AccountServiceTest extends AbstractAccountTest {

    @Mock
    private AccountRepository accountRepository;

    private AccountServiceImpl service;


    @Test
    void canRegisterAccount() {
        //given
        AccountDto accountToRegister = createTestAccountDto();
        //when
        when(accountRepository.save(any())).thenReturn(createMockAccount());
        service.add(accountToRegister);

        //then
        //catch argument
        ArgumentCaptor<Account> accountArgumentCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository).save(accountArgumentCaptor.capture());
        //compare values
        Account capturedAccount = accountArgumentCaptor.getValue();
        assertThat(capturedAccount.getEmail()).isEqualTo(accountToRegister.getEmail());
        assertThat(capturedAccount.getPassword()).isEqualTo(accountToRegister.getPassword());
    }


    @Test
    void canLoadAccount() {
        //given
        Account mockAccount = createMockAccount();
        when(accountRepository.findById(any())).thenReturn(Optional.of(mockAccount));
        //when
        AccountDto loadedAccountDto = service.load(1L);
        //then
        verify(accountRepository).findById(1L);
        assertThat(loadedAccountDto.getId()).isEqualTo(mockAccount.getId());
        assertThat(loadedAccountDto.getEmail()).isEqualTo(mockAccount.getEmail());
        assertThat(loadedAccountDto.getPassword()).isEqualTo(mockAccount.getPassword());
    }


    @Test
    void shouldThrowObjectNotFoundException() {
        //given
        when(accountRepository.findById(any())).thenReturn(Optional.empty());
        //when && then
        assertThatThrownBy(() -> service.load(1L)).isInstanceOf(ObjectNotFoundException.class);
    }


}