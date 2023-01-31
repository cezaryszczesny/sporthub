package pl.studies.sporthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import pl.studies.sporthub.service.coach.CoachDto;


@Data
@Entity
@ToString
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operator", referencedColumnName = "id")
    private Operator operator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_specialty", referencedColumnName = "id")
    private CoachSpecialty specialty;

    @NotNull
    private Boolean isActive;


    public void apply(CoachDto dto) {
        BeanUtils.copyProperties(dto, this);
    }


    public CoachDto createDto() {
        CoachDto coachDto = new CoachDto();
        BeanUtils.copyProperties(this, coachDto);
        coachDto.setIdOperator(operator.getId());
        coachDto.setIdSpecialty(specialty.getId());
        return coachDto;
    }


}
