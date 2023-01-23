package pl.studies.sporthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import pl.studies.sporthub.service.task.TaskDto;

import java.util.Date;


@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operator_player")
    private Operator operatorPlayer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operator_coach")
    private Operator operatorCoach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operator_creator")
    private Operator operatorCreator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facility")
    private Facility facility;
    @NotNull
    private Date fromTime;

    @NotNull
    private Date toTime;


    public void apply(TaskDto dto) {
        BeanUtils.copyProperties(dto, this);
    }


    public TaskDto createDto() {
        TaskDto dto = new TaskDto();
        BeanUtils.copyProperties(this, dto);
        manageIds(dto);
        return dto;
    }


    private void manageIds(TaskDto dto) {
        //possible null values
        if (facility != null) {
            dto.setIdFacility(facility.getId());
        }

        //not null values
        dto.setIdCoach(operatorCoach.getCoach().getId());
        dto.setIdPlayer(operatorPlayer.getPlayer().getId());
        dto.setIdOperatorCreator(operatorCreator.getId());


    }
}
