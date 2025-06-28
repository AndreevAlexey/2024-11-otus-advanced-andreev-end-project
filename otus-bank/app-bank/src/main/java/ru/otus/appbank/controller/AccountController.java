package ru.otus.appbank.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.appbank.service.AccountService;
import ru.otus.common.dto.AccountDto;

import java.util.List;



@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @GetMapping("/account")
    public List<AccountDto> getAll() {
        return accountService.getAll();
    }


    @GetMapping("/account/{num}")
    public AccountDto getByNum(@PathVariable("num") String num) {
        return accountService.getByNum(num).orElse(null);
    }
}
