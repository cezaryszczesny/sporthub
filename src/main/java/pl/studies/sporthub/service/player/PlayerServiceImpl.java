package pl.studies.sporthub.service.player;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.model.Player;
import pl.studies.sporthub.service.operator.OperatorRepository;

import java.util.Optional;


@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {


    private PlayerRepository playerRepository;
    private OperatorRepository operatorRepository;


    @Override
    public Long add(PlayerDto dto) {
        Player player = new Player();
        player.apply(dto);
        assignOperatorToPlayer(player, dto.getIdOperator());
        playerRepository.save(player);
        addPlayerToOperator(dto.getIdOperator(), player);
        return player.getId();
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
