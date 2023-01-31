package pl.studies.sporthub.service.player;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.exception.ObjectNotFoundException;
import pl.studies.sporthub.model.*;
import pl.studies.sporthub.service.operator.OperatorRepository;
import pl.studies.sporthub.service.previousSeasonStats.PreviousSeasonStatsRepository;

import java.util.ArrayList;
import java.util.List;
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

    private PreviousSeasonStatsRepository previousSeasonStatsRepository;


    @Override
    public Long add(PlayerDto dto) {
        Player player = new Player();
        player.apply(dto);
        applyPreviousSeasonStats(player, dto);
        applySimpleRows(player, dto);
        assignOperatorToPlayer(player, dto.getIdOperator());
        playerRepository.save(player);
        manageOperator(dto.getIdOperator(), player);
        return player.getId();
    }


    private void applyPreviousSeasonStats(Player player, PlayerDto dto) {
        Long idStats = dto.getIdPreviousSeasonStats();
        if (idStats != null) {
            Optional<PreviousSeasonStats> possibleStats = previousSeasonStatsRepository.findById(idStats);
            if (possibleStats.isPresent()) {
                player.setPreviousSeasonStats(possibleStats.get());
            } else {
                throw new ObjectNotFoundException("Nie znaleziono statystyk zawodnika");
            }
        }
    }


    private void applySimpleRows(Player player, PlayerDto dto) {
        if (dto.getIdDiet() != null) {
            Optional<PlayerDiet> diet = playerDietRepository.findById(dto.getIdDiet());
            if (diet.isPresent()) {
                player.setPlayerDiet(diet.get());
            } else {
                throw new ObjectNotFoundException("Nie znaleziono diety zawodnika");
            }
        }

        if (dto.getIdStatus() != null) {
            Optional<PlayerStatus> status = playerStatusRepository.findById(dto.getIdStatus());
            if (status.isPresent()) {
                player.setPlayerStatus(status.get());
            } else {
                throw new ObjectNotFoundException("Nie znaleziono statusu zawodnika");
            }
        }

        if (dto.getIdFoot() != null) {
            Optional<PlayerFoot> foot = playerFootRepository.findById(dto.getIdFoot());
            if (foot.isPresent()) {
                player.setPlayerFoot(foot.get());
            } else {
                throw new ObjectNotFoundException("Nie znaleziono nogi dominującej");
            }
        }
        if (dto.getIdPlayerPosition() != null) {
            Optional<PlayerPosition> position = playerPositionRepository.findById(dto.getIdPlayerPosition());
            if (position.isPresent()) {
                player.setPlayerPosition(position.get());
            } else {
                throw new ObjectNotFoundException("Nie znaleziono pozycji zawodnika");
            }
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


    private void manageOperator(Long idOperator, Player player) {
        operatorRepository.findById(idOperator).ifPresent(operator -> {
            operator.setPlayer(player);
            operator.setIsPlayer(Boolean.TRUE);
            operatorRepository.save(operator);
        });
    }


    @Override
    public PlayerDto load(Long id) {
        Optional<Player> possiblePlayer = playerRepository.findById(id);
        if (possiblePlayer.isPresent()) {
            Player player = possiblePlayer.get();
            PlayerDto dto = player.createDto();
            return dto;
        }
        return null;
    }


    @Override
    public void delete(Long id) {

    }


    @Override
    public void update(PlayerDto dto) {

    }


    @Override
    public List<PlayerDto> findAll() {
        Iterable<Player> allPlayers = playerRepository.findAll();
        List<PlayerDto> players = new ArrayList<>();
        allPlayers.forEach(player -> players.add(player.createDto()));
        return players;
    }
}
