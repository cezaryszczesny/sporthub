package pl.studies.sporthub.service.operator;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.model.Operator;

import java.util.Optional;


@Service
@AllArgsConstructor
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository operatorRepository;


    @Override
    public Long add(OperatorDto dto) {
        Operator operator = new Operator();
        operator.apply(dto);
        Operator savedOperator = operatorRepository.save(operator);
        return savedOperator.getId();
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
}
