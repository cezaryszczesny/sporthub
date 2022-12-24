package pl.studies.sporthub.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import pl.studies.sporthub.service.SimpleRowDto;
import pl.studies.sporthub.service.player.PlayerDto;

import java.util.Date;


@SuppressWarnings("JpaAttributeTypeInspection")
@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operator", referencedColumnName = "id")
    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "id_position", referencedColumnName = "id")
    private PlayerPosition playerPosition;

    private Date birthDate;

    private Integer height;

    private Integer weight;

    private String teamName;

    @ManyToOne
    @JoinColumn(name = "id_foot", referencedColumnName = "id")
    private PlayerFoot playerFoot;

    @ManyToOne
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    private PlayerStatus playerStatus;

    @ManyToOne
    @JoinColumn(name = "id_diet", referencedColumnName = "id")
    private PlayerDiet playerDiet;


    public void apply(PlayerDto dto) {
        BeanUtils.copyProperties(dto, this);
    }


    public PlayerDto createDto() {
        PlayerDto dto = new PlayerDto();
        BeanUtils.copyProperties(this, dto);
        manageIds(dto);
        return dto;
    }


    private void manageIds(PlayerDto dto) {
        if (playerStatus != null) {
            SimpleRowDto status = new SimpleRowDto(
                    playerStatus.getId(),
                    playerStatus.getName()
            );
            dto.setStatus(status);
        }
    }
}
