package pl.studies.sporthub.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.studies.sporthub.service.operator.OperatorDto;
import pl.studies.sporthub.service.operator.OperatorService;


@RestController
@RequestMapping("operators")
@AllArgsConstructor
public class OperatorController extends BaseApiController {

    private OperatorService service;


    @GetMapping(path = "/{id}")
    public OperatorDto getOperator(@PathVariable Long id) {
        loginBasic64();
        return service.load(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public OperatorDto saveOperator(@RequestBody OperatorDto dto) {
        loginBasic64();
        Long idSavedOperator = service.add(dto);
        return service.load(idSavedOperator);
    }
}
