package pl.studies.sporthub.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.studies.sporthub.model.PlayerDiet;
import pl.studies.sporthub.model.PlayerFoot;
import pl.studies.sporthub.model.PlayerPosition;
import pl.studies.sporthub.model.PlayerStatus;
import pl.studies.sporthub.service.SimpleRowDto;
import pl.studies.sporthub.service.player.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("players")
@AllArgsConstructor
public class PlayerController extends BaseApiController {

    private PlayerFootRepository playerFootRepository;
    private PlayerStatusRepository playerStatusRepository;
    private PlayerDietRepository playerDietRepository;
    private PlayerPositionRepository playerPositionRepository;
    private PlayerService playerService;


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private PlayerDto getPlayer(@PathVariable Long id) {
        return playerService.load(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PlayerDto addPlayer(@RequestBody PlayerDto dto) {
        Long idSavedPlayer = playerService.add(dto);
        PlayerDto savedPlayer = playerService.load(idSavedPlayer);
        return savedPlayer;
    }


    @GetMapping(path = "/feet")
    private List<SimpleRowDto> findPlayerFeet() {
        Iterable<PlayerFoot> feet = playerFootRepository.findAll();
        List<SimpleRowDto> feetList = new ArrayList<>();
        feet.forEach(foot -> feetList.add(foot.createDto()));
        return feetList;
    }


    @GetMapping(path = "/statuses")
    private List<SimpleRowDto> findPlayerStatus() {
        Iterable<PlayerStatus> statuses = playerStatusRepository.findAll();
        List<SimpleRowDto> statusesList = new ArrayList<>();
        statuses.forEach(status -> statusesList.add(status.createDto()));
        return statusesList;
    }


    @GetMapping(path = "/diets")
    private List<SimpleRowDto> findPlayerDiets() {
        Iterable<PlayerDiet> diets = playerDietRepository.findAll();
        List<SimpleRowDto> dietsList = new ArrayList<>();
        diets.forEach(diet -> dietsList.add(diet.createDto()));
        return dietsList;
    }


    @GetMapping(path = "/positions")
    private List<SimpleRowDto> findPlayerPosition() {
        Iterable<PlayerPosition> positions = playerPositionRepository.findAll();
        List<SimpleRowDto> positionsList = new ArrayList<>();
        positions.forEach(position -> positionsList.add(position.createDto()));
        return positionsList;
    }

}
