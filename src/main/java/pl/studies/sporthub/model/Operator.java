package pl.studies.sporthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import pl.studies.sporthub.service.operator.OperatorDto;

import java.util.Set;


@Data
@Entity
@ToString
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_account", referencedColumnName = "id", nullable = false)
    private Account account;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Boolean isPlayer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_player", referencedColumnName = "id")
    private Player player;

    @OneToOne
    @JoinColumn(name = "id_coach", referencedColumnName = "id")
    private Coach coach;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "operatorPlayer")
    private Set<Task> playerTasks;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "operatorCoach")
    private Set<Task> coachTasks;


    public void apply(OperatorDto dto) {
        BeanUtils.copyProperties(dto, this);
    }


    public OperatorDto createDto() {
        OperatorDto dto = new OperatorDto();
        BeanUtils.copyProperties(this, dto);
        manageIds(dto);
        manageTasks(dto);
        return dto;
    }


    private void manageTasks(OperatorDto dto) {
        //TODO: obsługa tasków przy operatorze
    }


    private void manageIds(OperatorDto dto) {
        dto.setIdAccount(account.getId());
        if (coach != null) {
            dto.setIdCoach(coach.getId());
        }
        if (player != null) {
            dto.setIdPlayer(player.getId());
        }
    }
}
