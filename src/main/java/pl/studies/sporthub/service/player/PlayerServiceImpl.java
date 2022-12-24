package pl.studies.sporthub.service.player;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.model.*;
import pl.studies.sporthub.service.BaseRepository;
import pl.studies.sporthub.service.operator.OperatorRepository;

import java.util.Optional;


@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {


    private PlayerRepository playerRepository;
    private OperatorRepository operatorRepository;
    private BaseRepository baseRepository;


    @Override
    public Long add(PlayerDto dto) {
        Player player = new Player();
        player.apply(dto);
        assignOperatorToPlayer(player, dto.getIdOperator());
        assignEnums(player, dto);
        playerRepository.save(player);
        addPlayerToOperator(dto.getIdOperator(), player);
        return player.getId();
    }


    private void assignEnums(Player player, PlayerDto dto) {
        if (dto.getPlayerPosition() != null) {
            PlayerPosition position = getPlayerPosition(dto.getPlayerPosition().getId());
            player.setPlayerPosition(position);
        }
        if (dto.getFoot() != null) {
            PlayerFoot foot = getPlayerFoot(dto.getFoot().getId());
            player.setPlayerFoot(foot);
        }
        if (dto.getDiet() != null) {
            PlayerDiet diet = getPlayerDiet(dto.getDiet().getId());
            player.setPlayerDiet(diet);
        }
        if (dto.getStatus() != null) {
            PlayerStatus status = getPlayerStatus(dto.getStatus().getId());
            player.setPlayerStatus(status);
        }
    }


    private PlayerStatus getPlayerStatus(Long id) {
        return baseRepository.load(PlayerStatus.class, id);
    }


    private PlayerDiet getPlayerDiet(Long id) {
        return baseRepository.load(PlayerDiet.class, id);
    }


    private PlayerFoot getPlayerFoot(Long id) {
        return baseRepository.load(PlayerFoot.class, id);
    }


    private PlayerPosition getPlayerPosition(Long id) {
        return baseRepository.load(PlayerPosition.class, id);
    }


    private void assignOperatorToPlayer(Player player, Long idOperator) {
        Optional<Operator> possibleOperator = operatorRepository.findById(idOperator);
        possibleOperator.ifPresent(operator -> player.setOperator(operator));
    }


    private void addPlayerToOperator(Long idOperator, Player player) {
        operatorRepository.findById(idOperator).ifPresent(operator -> operator.setPlayer(player));
    }


    @Override
    public PlayerDto load(Long id) {
        Optional<Player> possiblePlayer = playerRepository.findById(id);
        if (possiblePlayer.isPresent()) {
            Player player = possiblePlayer.get();
            PlayerDto dto = player.createDto();
        }
        return null;
    }


    @Override
    public void delete(Long id) {

    }


    @Override
    public void update(PlayerDto dto) {

    }
}
