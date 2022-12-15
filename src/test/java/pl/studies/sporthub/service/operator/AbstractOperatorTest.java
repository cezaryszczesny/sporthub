package pl.studies.sporthub.service.operator;

import org.junit.jupiter.api.BeforeAll;
import pl.studies.sporthub.constance.ConstTest;


public class AbstractOperatorTest {

    @BeforeAll
    void prepareData() {

    }


    protected OperatorDto createSimpleOperatorDto() {
        OperatorDto dto = new OperatorDto();
        dto.setIdAccount(ConstTest.ID_ACCOUNT);
        dto.setIsPlayer(Boolean.TRUE);
        dto.setFirstName(ConstTest.FIRST_NAME);
        dto.setLastName(ConstTest.LAST_NAME);

        return dto;
    }
}
