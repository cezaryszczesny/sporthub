package pl.studies.sporthub.service.operator;

public interface OperatorService {

    Long add(OperatorDto dto);

    OperatorDto load(Long idOperator);

}
