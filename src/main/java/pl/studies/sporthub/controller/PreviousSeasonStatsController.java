package pl.studies.sporthub.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.studies.sporthub.service.previousSeasonStats.PreviousSeasonStatsDto;
import pl.studies.sporthub.service.previousSeasonStats.PreviousSeasonStatsService;


@RestController
@RequestMapping("previousSeasonStats")
@AllArgsConstructor
public class PreviousSeasonStatsController {

    private PreviousSeasonStatsService service;


    @GetMapping(path = "/{id}")
    public PreviousSeasonStatsDto getPreviousSeasonStatsByIdPlayer(@PathVariable Long id) {
        return service.load(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PreviousSeasonStatsDto savePreviousSeasonStats(@RequestBody PreviousSeasonStatsDto dto) {
        Long idSavedStats = service.add(dto);
        return service.load(idSavedStats);
    }
}
