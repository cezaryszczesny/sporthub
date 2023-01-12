package pl.studies.sporthub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.studies.sporthub.model.PlayerDiet;
import pl.studies.sporthub.model.PlayerFoot;
import pl.studies.sporthub.model.PlayerPosition;
import pl.studies.sporthub.model.PlayerStatus;
import pl.studies.sporthub.service.SimpleRowDto;
import pl.studies.sporthub.service.player.PlayerDietRepository;
import pl.studies.sporthub.service.player.PlayerFootRepository;
import pl.studies.sporthub.service.player.PlayerPositionRepository;
import pl.studies.sporthub.service.player.PlayerStatusRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("players")
public class PlayerController extends BaseApiController {

    @Autowired
    private PlayerFootRepository playerFootRepository;
    @Autowired
    private PlayerStatusRepository playerStatusRepository;
    @Autowired
    private PlayerDietRepository playerDietRepository;
    @Autowired
    private PlayerPositionRepository playerPositionRepository;


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
