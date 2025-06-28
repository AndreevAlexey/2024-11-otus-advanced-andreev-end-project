package ru.otus.appbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.appbank.service.CurrencyService;
import ru.otus.common.dto.CurrencyDto;

import java.util.List;



@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;


    @GetMapping("/currency/{code}")
    public CurrencyDto getByCode(@PathVariable("code") String code) {
        return currencyService.getFromCache(code);
    }


    @GetMapping("/currency")
    public List<CurrencyDto> getAll() {
        return currencyService.getAllFromCache();
    }
}
