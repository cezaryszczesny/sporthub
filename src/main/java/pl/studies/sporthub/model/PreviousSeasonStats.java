package pl.studies.sporthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import pl.studies.sporthub.service.previousSeasonStats.PreviousSeasonStatsDto;


@Entity
@Data
@ToString
public class PreviousSeasonStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_player", referencedColumnName = "id")
    private Player player;
    @NotNull
    private Integer goals;
    @NotNull
    private Integer assists;
    @NotNull
    private Integer redCards;
    @NotNull
    private Integer yellowCards;


    public void apply(PreviousSeasonStatsDto dto) {
        BeanUtils.copyProperties(dto, this);
    }


    public PreviousSeasonStatsDto createDto() {
        PreviousSeasonStatsDto dto = new PreviousSeasonStatsDto();
        BeanUtils.copyProperties(this, dto);
        dto.setIdPlayer(player.getId());
        return dto;
    }
}

