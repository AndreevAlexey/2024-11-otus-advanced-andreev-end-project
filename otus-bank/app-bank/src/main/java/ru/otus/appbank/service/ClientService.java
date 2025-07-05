package ru.otus.appbank.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.appbank.feign.ClientFeign;
import ru.otus.common.dto.ClientDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientFeign clientFeign;


    @Retry(name = "default")
    @RateLimiter(name = "rpm_10")
    @CircuitBreaker(name = "default")
    public List<ClientDto> getClients() {
        return clientFeign.getClients();
    }


    @Retry(name = "default")
    @RateLimiter(name = "rps_10")
    @CircuitBreaker(name = "default")
    public ClientDto findByInn(String inn) {
        return clientFeign.findByInn(inn);
    }


    @Retry(name = "default")
    @RateLimiter(name = "rps_10")
    @CircuitBreaker(name = "default")
    public ClientDto update(ClientDto item) {
        return clientFeign.update(item);
    }


    @Retry(name = "default")
    @RateLimiter(name = "rps_10")
    @CircuitBreaker(name = "default")
    public ClientDto add(ClientDto item) {
        return clientFeign.add(item);
    }
}
