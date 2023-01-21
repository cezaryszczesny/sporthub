package pl.studies.sporthub.service.previousSeasonStats;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.exception.ObjectNotFoundException;
import pl.studies.sporthub.model.Player;
import pl.studies.sporthub.model.PreviousSeasonStats;
import pl.studies.sporthub.service.player.PlayerRepository;

import java.util.Optional;


@Service
@AllArgsConstructor
public class PreviousSeasonStatsServiceImpl implements PreviousSeasonStatsService {

    private PreviousSeasonStatsRepository repo;
    private PlayerRepository playerRepository;


    @Override
    public Long add(PreviousSeasonStatsDto dto) {
        PreviousSeasonStats stats = new PreviousSeasonStats();
        stats.apply(dto);
        assignPlayer(stats, dto);
        PreviousSeasonStats savedStats = repo.save(stats);
        managePlayer(savedStats);
        return savedStats.getId();
    }


    private void managePlayer(PreviousSeasonStats stats) {
        Player player = stats.getPlayer();
        player.setPreviousSeasonStats(stats);
        playerRepository.save(player);
    }


    private void assignPlayer(PreviousSeasonStats stats, PreviousSeasonStatsDto dto) {
        Optional<Player> possiblePlayer = playerRepository.findById(dto.getIdPlayer());
        if (possiblePlayer.isPresent()) {
            Player player = possiblePlayer.get();
            stats.setPlayer(player);
        } else {
            throw new ObjectNotFoundException("Nie znaleziono zawodnika");
        }
    }


    @Override
    public PreviousSeasonStatsDto load(Long id) {
        Optional<PreviousSeasonStats> possibleStats = repo.findById(id);
        if (possibleStats.isPresent()) {
            return possibleStats.get().createDto();
        } else {
            throw new ObjectNotFoundException("Nie znaleziono statystyk");
        }
    }


    @Override
    public void delete(Long id) {

    }


    @Override
    public void update(PreviousSeasonStatsDto dto) {

    }


    @Override
    public PreviousSeasonStatsDto findByPlayerId(Long idPlayer) {
        PreviousSeasonStats possibleStats = repo.findByPlayerId(idPlayer);
        if (possibleStats != null) {
            return possibleStats.createDto();
        } else {
            throw new ObjectNotFoundException("Nie znaleziono statystyk dla zawodnika");
        }
    }
}
