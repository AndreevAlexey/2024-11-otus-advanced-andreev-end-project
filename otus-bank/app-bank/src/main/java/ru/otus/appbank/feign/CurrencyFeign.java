package ru.otus.appbank.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.common.dto.CurrencyDto;

import java.util.List;

@FeignClient(name = "CurrencyFeign", url = "${feign.gateway.url}")
public interface CurrencyFeign {

    @GetMapping("/currency")
    List<CurrencyDto> getAll();


    @GetMapping("/currency/{code}")
    CurrencyDto getByCode(@PathVariable("code") String code);
}
