package ru.otus.appclients.model;


import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import ru.otus.common.dto.ClientDto;

import java.time.LocalDate;


@Hidden
@Entity
@Table(schema = "app_clients", name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "mail")
    private String mail;

    @Column(name = "inn")
    private String inn;


    public ClientDto toDto() {
        return
                (this instanceof HibernateProxy)
                        ? new ClientDto()
                        : new ClientDto(id, fullName, birthDate, mail, inn);
    }


    public static Client toEntity(ClientDto dto) {
        return
                (dto == null)
                        ? null
                        : new Client(dto.getId(), dto.getFullName(), dto.getBirthDate(), dto.getMail(), dto.getInn());
    }

}
