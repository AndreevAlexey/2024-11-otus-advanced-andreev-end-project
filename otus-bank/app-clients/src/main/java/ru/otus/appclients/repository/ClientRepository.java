package ru.otus.appclients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.appclients.model.Client;


import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientByInn(String inn);


}
