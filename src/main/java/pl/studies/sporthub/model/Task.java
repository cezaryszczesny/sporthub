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
    @JoinColumn(name="id_operator")
    private Operator operator;

    @NotNull
    private String playerFullName;

    @NotNull
    private String coachFullName;

    @NotNull
    private String creatorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_facility")
    private Facility facility;

    @NotNull
    private Date fromTime;

    @NotNull
    private Date toTime;




}
