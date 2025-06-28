package ru.otus.appmoves.model;


import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import ru.otus.common.dto.MoveDto;

import java.time.LocalDate;

@Hidden
@Entity
@Table(schema = "app_moves", name = "moves")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "acc_dt")
    private String accDt;

    @Column(name = "acc_kt")
    private String accKt;

    @Column(name = "doc_date")
    private LocalDate docDate;

    @Column(name = "sum_dt")
    private double sumDt;

    @Column(name = "sum_kt")
    private double sumKt;

    @Column(name = "description")
    private String description;


    public MoveDto toDto() {
        return
                (this instanceof HibernateProxy)
                        ? new MoveDto()
                        : new MoveDto(id, accDt, accKt, docDate, sumDt, sumKt, description);
    }


    public static Move toEntity(MoveDto dto) {
        return
                (dto == null)
                        ? null
                        : new Move(dto.getId(),
                                   dto.getAccDt(),
                                   dto.getAccKt(),
                                   dto.getDocDate(),
                                   dto.getSumDt(),
                                   dto.getSumKt(),
                                   dto.getDescription());
    }
}
