package ru.otus.appmanuals.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.appmanuals.model.Currency;
import ru.otus.appmanuals.repository.CurrencyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;


    @Transactional(readOnly = true)
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Currency getByCode(String code) {
        return currencyRepository.findFirstByCode(code).orElse(null);
    }

}
