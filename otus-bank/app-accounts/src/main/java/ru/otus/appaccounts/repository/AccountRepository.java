package ru.otus.appaccounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.appaccounts.model.Account;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findFirstByNum(String num);
}
