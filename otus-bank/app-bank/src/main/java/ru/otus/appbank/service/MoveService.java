package ru.otus.appbank.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.appbank.exception.NoDataFoundException;
import ru.otus.appbank.feign.MoveFeign;
import ru.otus.common.dto.AccountDto;
import ru.otus.common.dto.CurrencyDto;
import ru.otus.common.dto.MoveDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class MoveService {

    private final MoveFeign moveFeign;

    private final AccountService accountService;

    private final CurrencyService currencyService;


    @Retry(name = "default")
    @RateLimiter(name = "rpm_10")
    @CircuitBreaker(name = "default")
    public List<MoveDto> getAll(Optional<LocalDate> begin, Optional<LocalDate> end) {
        log.info("get all moves");
        return moveFeign.getAll(begin, end);
    }


    @Retry(name = "default")
    @RateLimiter(name = "rps_10")
    @CircuitBreaker(name = "default")
    public List<MoveDto> findAllByAccount(String account) {
        log.info("get all moves by account {}", account);
        return moveFeign.findAllByAccount(account);
    }



    @Retry(name = "default")
    @RateLimiter(name = "rps_10")
    @CircuitBreaker(name = "default")
    public MoveDto add(MoveDto move) {
        log.info("==> ADD NEW MOVE (start)");
        AccountDto accDt = accountService.getByNum(move.getAccDt())
                .orElseThrow(() -> new NoDataFoundException("Account %s not found".formatted(move.getAccDt())));
        log.info("account debit {}", accDt.getNum());

        AccountDto accKt = accountService.getByNum(move.getAccKt())
                .orElseThrow(() -> new NoDataFoundException("Account %s not found".formatted(move.getAccKt())));
        log.info("account credit {}", accKt.getNum());

        if (accDt.getSaldo() < move.getSumDt()) {
            log.error("Not enough money for debit");
            throw new ArithmeticException("Not enough money for debit");
        }

        CurrencyDto curDt = currencyService.getFromCache(accDt.getCurrency());
        log.info("currency debit {}", curDt.getCode());
        CurrencyDto curKt = currencyService.getFromCache(accKt.getCurrency());
        log.info("currency credit {}", curKt.getCode());

        log.info("sum debit {}", move.getSumDt());
        accDt.setSaldo(accDt.getSaldo() - move.getSumDt());
        accountService.update(accDt);

        double sumKt = move.getSumDt() * curDt.getCurs()/curKt.getCurs();
        log.info("sum credit {}", sumKt);
        accKt.setSaldo(accKt.getSaldo() + sumKt);
        accountService.update(accKt);

        MoveDto newMove = moveFeign.add(move);
        log.info("<== ADD NEW MOVE (end)");
        return newMove;
    }

}
