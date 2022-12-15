package pl.studies.sporthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import pl.studies.sporthub.service.account.AccountDto;

import java.util.Calendar;
import java.util.Date;


@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_operator", referencedColumnName = "id")
    private Operator operator;

    @Email
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Date createTime;


    @PrePersist
    void createdTime() {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        this.createTime = time;
    }


    public void apply(AccountDto dto) {
        BeanUtils.copyProperties(dto, this);
    }


    public AccountDto createDto() {
        AccountDto dto = new AccountDto();
        if (operator != null) {
            dto.setIdOperator(operator.getId());
        }
        BeanUtils.copyProperties(this, dto);
        return dto;
    }
}
