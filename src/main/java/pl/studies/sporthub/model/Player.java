package pl.studies.sporthub.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


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
}
