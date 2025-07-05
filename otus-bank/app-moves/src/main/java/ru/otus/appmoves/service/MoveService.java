package ru.otus.appmoves.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.appmoves.model.Move;
import ru.otus.appmoves.repository.MoveRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoveService {

    private final MoveRepository moveRepository;


    @Transactional(readOnly = true)
    public List<Move> getAll() {
        return moveRepository.findAll();
    }


    @Transactional(readOnly = true)
    public List<Move> findAllByAccount(String account) {
        return moveRepository.findAllByAccDtOrAccKt(account, account);
    }


    @Transactional(readOnly = true)
    public List<Move> findAllByDocDateBetween(LocalDate begin, LocalDate end) {
        return moveRepository.findAllByDocDateBetween(begin, end);
    }


    @Transactional
    public Move save(Move item) {
        return moveRepository.save(item);
    }

}
