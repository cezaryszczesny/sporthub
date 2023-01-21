package pl.studies.sporthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;


@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


}
