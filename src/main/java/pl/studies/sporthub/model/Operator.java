package pl.studies.sporthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;


@Data
@Entity
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="id_account", referencedColumnName = "id", nullable = false)
    private Account account;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operator_role", referencedColumnName = "id", nullable = false)
    private OperatorRole operatorRole;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_player", referencedColumnName = "id")
    private Player player;

    @OneToOne
    @JoinColumn(name="id_coach", referencedColumnName = "id")
    private Coach coach;

//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "operator")
//    private Set<Task> tasks;

}
