package pl.studies.sporthub.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.studies.sporthub.service.coach.CoachDto;
import pl.studies.sporthub.service.coach.CoachService;


@RestController
@RequestMapping("coaches")
@AllArgsConstructor
public class CoachController extends BaseApiController {

    private CoachService service;


    @GetMapping(path = "/{id}")
    public CoachDto getCoach(@PathVariable Long id) {
        return service.load(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CoachDto addCoach(@RequestBody CoachDto dto) {
        Long idSavedCoach = service.add(dto);
        return service.load(idSavedCoach);
    }
}
