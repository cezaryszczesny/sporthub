package pl.studies.sporthub.service.operator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class OperatorServiceTest extends AbstractOperatorTest {

    @Mock
    private OperatorRepository operatorRepository;
    private OperatorServiceImpl service;


    @BeforeEach
    void setUp() {
        service = new OperatorServiceImpl(operatorRepository);
    }


    @Test
    void canAdd() {
        //given

    }


    @Test
    void canLoad() {
    }
}