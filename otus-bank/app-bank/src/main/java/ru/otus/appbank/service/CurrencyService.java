package ru.otus.appbank.service;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.otus.appbank.cache.CurrencyCache;
import ru.otus.appbank.feign.CurrencyFeign;
import ru.otus.common.dto.CurrencyDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyFeign currencyFeign;

    private final CurrencyCache cache = new CurrencyCache();


    @PostConstruct
    private void init() {
        updateCache();
    }


    private void updateCache() {
        List<CurrencyDto> items = currencyFeign.getAll();
        for (CurrencyDto curr : items) {
            cache.addToCache(curr.getCode(), curr);
        }
    }


    @Scheduled(cron = "${scheduler.cron.currency:0 0 8 * * MON-FRI}")
    private void job() {
        updateCache();
    }


    private void checkCache() {
        if (cache.isEmpty()) {
            updateCache();
        }
    }


    public CurrencyDto getFromCache(String code) {
        checkCache();
        return cache.getFromCache(code);
    }


    public List<CurrencyDto> getAllFromCache() {
        checkCache();
        return cache.getAll();
    }
}
