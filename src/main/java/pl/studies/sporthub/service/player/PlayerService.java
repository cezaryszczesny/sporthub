package pl.studies.sporthub.service.player;

import pl.studies.sporthub.service.BaseApplicationService;

import java.util.List;


public interface PlayerService extends BaseApplicationService<PlayerDto> {


    List<PlayerDto> findAll();
}
