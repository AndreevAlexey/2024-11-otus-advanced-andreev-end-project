package ru.otus.appmoves.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.appmoves.model.Move;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {

    List<Move> findAllByAccDtOrAccKt(String accDt, String accKt);

    List<Move> findAllByDocDateBetween(LocalDate begin, LocalDate end);
}
