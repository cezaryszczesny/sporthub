package pl.studies.sporthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Data
@Entity
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_operator", referencedColumnName = "id")
    private Operator operator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_coach_specialty", referencedColumnName = "id")
    private CoachSpecialty specialty;

    @NotNull
    private Boolean isActive;
}
