package ru.otus.appbank.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.appbank.feign.AccountFeign;
import ru.otus.common.dto.AccountDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountFeign accountFeign;


    @Retry(name = "default")
    @RateLimiter(name = "rpm_10")
    @CircuitBreaker(name = "default")
    public List<AccountDto> getAll() {
        return accountFeign.getAll();
    }


    @Retry(name = "default")
    @RateLimiter(name = "rps_10")
    @CircuitBreaker(name = "default")
    public Optional<AccountDto> getByNum(String num) {
        return accountFeign.getByNum(num);
    }


    @Retry(name = "default")
    @RateLimiter(name = "rps_10")
    @CircuitBreaker(name = "default")
    public AccountDto update(AccountDto account) {
        return accountFeign.update(account);
    }
}
