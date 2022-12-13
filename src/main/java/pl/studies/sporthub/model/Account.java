package pl.studies.sporthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.BeanUtils;
import pl.studies.sporthub.service.account.AccountDto;

import java.util.Date;


@Data
@Entity
public class Account {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Operator.class)
    private Operator operator;

    @Email
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Date createTime;

    @PrePersist
    void createdTime(){
        this.createTime = new Date();
    }


    public void apply(AccountDto dto) {
        BeanUtils.copyProperties(dto, this);
    }


    public AccountDto createDto() {
        AccountDto dto = new AccountDto();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
