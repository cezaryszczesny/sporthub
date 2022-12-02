package pl.studies.sporthub.model;

import jakarta.persistence.*;
import lombok.*;
import pl.studies.sporthub.service.account.AccountDto;

import java.util.Date;


/**
 *
 */
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Operator.class)
    private Operator operator;

    @Column(unique = true)
    private String email;
    private String password;
    private Date createTime;

    @PrePersist
    void createdTime(){
        this.createTime = new Date();
    }


    public void apply(AccountDto dto) {

    }
}
