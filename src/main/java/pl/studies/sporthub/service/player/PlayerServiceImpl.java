package pl.studies.sporthub.service.player;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.exception.ObjectNotFoundException;
import pl.studies.sporthub.model.*;
import pl.studies.sporthub.service.operator.OperatorRepository;

import java.util.Optional;


@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {


    private PlayerRepository playerRepository;
    private OperatorRepository operatorRepository;


    private PlayerDietRepository playerDietRepository;
    private PlayerFootRepository playerFootRepository;
    private PlayerStatusRepository playerStatusRepository;
    private PlayerPositionRepository playerPositionRepository;


    @Override
    public Long add(PlayerDto dto) {
        Player player = new Player();
        player.apply(dto);
        applySimpleRows(player, dto);
        assignOperatorToPlayer(player, dto.getIdOperator());
        playerRepository.save(player);
        addPlayerToOperator(dto.getIdOperator(), player);
        return player.getId();
    }


    private void applySimpleRows(Player player, PlayerDto dto) {
        Optional<PlayerDiet> diet = playerDietRepository.findById(dto.getIdDiet());
        if (diet.isPresent()) {
            player.setPlayerDiet(diet.get());
        } else {
            throw new ObjectNotFoundException("Nie znaleziono diety zawodnika");
        }

        Optional<PlayerStatus> status = playerStatusRepository.findById(dto.getIdStatus());
        if (status.isPresent()) {
            player.setPlayerStatus(status.get());
        } else {
            throw new ObjectNotFoundException("Nie znaleziono statusu zawodnika");
        }

        Optional<PlayerFoot> foot = playerFootRepository.findById(dto.getIdFoot());
        if (foot.isPresent()) {
            player.setPlayerFoot(foot.get());
        } else {
            throw new ObjectNotFoundException("Nie znaleziono nogi dominującej");
        }
        Optional<PlayerPosition> position = playerPositionRepository.findById(dto.getIdFoot());
        if (position.isPresent()) {
            player.setPlayerPosition(position.get());
        } else {
            throw new ObjectNotFoundException("Nie znaleziono pozycji zawodnika");
        }

    }


    private void assignOperatorToPlayer(Player player, Long idOperator) {
        Optional<Operator> possibleOperator = operatorRepository.findById(idOperator);
        if (possibleOperator.isPresent()) {
            player.setOperator(possibleOperator.get());
        } else {
            throw new ObjectNotFoundException("Nie znaleziono operatora");
        }
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
