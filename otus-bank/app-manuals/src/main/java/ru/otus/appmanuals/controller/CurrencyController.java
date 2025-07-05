package ru.otus.appmanuals.controller;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.appmanuals.model.Currency;
import ru.otus.appmanuals.service.CurrencyService;
import ru.otus.common.dto.CurrencyDto;

import java.util.List;


@Tag(
        name = "Currency API",
        description = "Api for currency"
)
@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;


    @GetMapping("/currency")
    public List<CurrencyDto> getAll() {
        return
                currencyService.getAll()
                        .stream()
                        .map(Currency::toDto)
                        .toList();
    }


    @GetMapping("/currency/{code}")
    public CurrencyDto getByCode(
            @Parameter(description = "currency code", required = true) @PathVariable("code") String code) {
        Currency currency = currencyService.getByCode(code);
        return
                (currency != null)
                        ? currency.toDto()
                        : null;
    }

}
