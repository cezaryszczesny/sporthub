package pl.studies.sporthub.service.operator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.studies.sporthub.constance.ConstTest;
import pl.studies.sporthub.model.Account;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.service.account.AccountRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OperatorServiceTest extends AbstractOperatorTest {

    @Mock
    private OperatorRepository operatorRepository;
    @Mock
    private AccountRepository accountRepository;
    private OperatorServiceImpl service;


    @BeforeEach
    void setUp() {
        service = new OperatorServiceImpl(operatorRepository, accountRepository);
    }


    @Test
    void canAddSimpleOperator() {
        //given
        OperatorDto operatorToAdd = createSimpleOperatorDto();
        when(operatorRepository.save(any())).thenReturn(createMockOperator());
        Account account = new Account();
        account.setId(ConstTest.ID_ACCOUNT);
        when(accountRepository.findById(ConstTest.ID_ACCOUNT)).thenReturn(Optional.of(account));
        //when
        Long savedId = service.add(operatorToAdd);
        //then catch argument
        ArgumentCaptor<Operator> operatorArgumentCaptor = ArgumentCaptor.forClass(Operator.class);
        verify(operatorRepository).save(operatorArgumentCaptor.capture());
        //compare values
        Operator capturedOperator = operatorArgumentCaptor.getValue();
        assertThat(capturedOperator.getId()).isNull();
        assertThat(capturedOperator.getFirstName()).isEqualTo(operatorToAdd.getFirstName());
        assertThat(capturedOperator.getLastName()).isEqualTo(operatorToAdd.getLastName());
        assertThat(capturedOperator.getIsPlayer()).isEqualTo(operatorToAdd.getIsPlayer());
        assertThat(capturedOperator.getAccount().getId()).isEqualTo(operatorToAdd.getIdAccount());
    }


    @Test
    void canAddPlayerOperator() {
        //given
        OperatorDto operatorToAdd = createSimpleOperatorDto();
        operatorToAdd.setIsPlayer(Boolean.TRUE);
        operatorToAdd.setIdPlayer(ConstTest.ID_PLAYER);
        when(operatorRepository.save(any())).thenReturn(createMockPlayerOperator());
        Account account = new Account();
        account.setId(ConstTest.ID_ACCOUNT);
        when(accountRepository.findById(ConstTest.ID_ACCOUNT)).thenReturn(Optional.of(account));
        //when
        Long savedId = service.add(operatorToAdd);
        //then catch argument
        ArgumentCaptor<Operator> operatorArgumentCaptor = ArgumentCaptor.forClass(Operator.class);
        verify(operatorRepository).save(operatorArgumentCaptor.capture());
        //compare values
        Operator capturedOperator = operatorArgumentCaptor.getValue();
        assertThat(capturedOperator.getId()).isNull();
        assertThat(capturedOperator.getFirstName()).isEqualTo(operatorToAdd.getFirstName());
        assertThat(capturedOperator.getLastName()).isEqualTo(operatorToAdd.getLastName());
        assertThat(capturedOperator.getIsPlayer()).isEqualTo(operatorToAdd.getIsPlayer());
        assertThat(capturedOperator.getAccount().getId()).isEqualTo(operatorToAdd.getIdAccount());
    }


    @Test
    void canLoad() {
    }
}