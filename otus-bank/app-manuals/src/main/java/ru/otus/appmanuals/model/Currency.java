package ru.otus.appmanuals.model;


import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import ru.otus.common.dto.CurrencyDto;

@Hidden
@Entity
@Table(schema = "app_manuals", name = "ft_money")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "curs")
    private double curs;


    public CurrencyDto toDto() {
        return
                (this instanceof HibernateProxy)
                        ? new CurrencyDto()
                        : new CurrencyDto(id, code, name, curs);
    }


    public static Currency toEntity(CurrencyDto dto) {
        return
                (dto != null)
                        ? new Currency(dto.getId(), dto.getCode(), dto.getName(), dto.getCurs())
                        : null;
    }

}
