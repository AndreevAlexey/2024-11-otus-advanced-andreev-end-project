package ru.otus.appaccounts.model;


import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import ru.otus.common.dto.AccountDto;

import java.time.LocalDate;

@Hidden
@Entity
@Table(schema = "app_accounts", name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "acc_num")
    private String num;

    @Column(name = "currency")
    private String currency;

    @Column(name = "open_date")
    private LocalDate openDate;

    @Column(name = "client_inn")
    private String clientInn;

    @Column(name = "saldo")
    private double saldo;


    public AccountDto toDto() {
        return
                (this instanceof HibernateProxy)
                        ? new AccountDto()
                        : new AccountDto(id, num, currency, openDate, clientInn, saldo);
    }


    public static Account toEntity(AccountDto dto) {
        return
                (dto == null)
                        ? null
                        : new Account(dto.getId(),
                                      dto.getNum(),
                                      dto.getCurrency(),
                                      dto.getOpenDate(),
                                      dto.getClientInn(),
                                      dto.getSaldo());
    }
}
