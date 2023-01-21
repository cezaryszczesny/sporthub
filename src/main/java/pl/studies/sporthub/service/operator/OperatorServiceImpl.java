package pl.studies.sporthub.service.operator;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.model.Account;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.service.account.AccountRepository;

import java.util.Optional;


@Service
@AllArgsConstructor
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository operatorRepository;
    private final AccountRepository accountRepository;


    @Override
    public Long add(OperatorDto dto) {
        Operator operator = new Operator();
        operator.apply(dto);
        assignOperatorToAccount(operator, dto.getIdAccount());
        Operator savedOperator = operatorRepository.save(operator);
        manageAccount(savedOperator);
        return savedOperator.getId();
    }


    private void manageAccount(Operator savedOperator) {
        Account account = savedOperator.getAccount();
        account.setOperator(savedOperator);
        accountRepository.save(account);
    }


    private void assignOperatorToAccount(Operator operator, Long idAccount) {
        Optional<Account> possibleAccount = accountRepository.findById(idAccount);
        if (possibleAccount.isPresent()) {
            Account account = possibleAccount.get();
            operator.setAccount(account);
        } else {
            //TODO: throw some exception
        }
    }


    @Override
    public OperatorDto load(Long idOperator) {
        Optional<Operator> load = operatorRepository.findById(idOperator);
        if (load.isPresent()) {
            Operator operator = load.get();
            return operator.createDto();
        } else {
            throw new ObjectNotFoundException(Operator.class.getName(), idOperator);
        }
    }


    @Override
    public void delete(Long id) {
        operatorRepository.deleteById(id);
    }


    @Override
    public void update(OperatorDto dto) {

    }
}
