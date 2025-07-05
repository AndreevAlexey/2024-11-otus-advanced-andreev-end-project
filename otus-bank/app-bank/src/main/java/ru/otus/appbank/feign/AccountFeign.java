package ru.otus.appbank.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.otus.common.dto.AccountDto;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "AccountFeign", url = "${feign.gateway.url}")
public interface AccountFeign {

    @GetMapping("/account")
    List<AccountDto> getAll();


    @GetMapping("/account/{num}")
    Optional<AccountDto> getByNum(@PathVariable("num") String num);


    @PutMapping("/account")
    AccountDto update(@RequestBody AccountDto account);
}
