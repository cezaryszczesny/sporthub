package pl.studies.sporthub.service.operator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.studies.sporthub.model.Operator;


@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long> {

}
