package ru.otus.appaccounts.controller;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.appaccounts.model.Account;
import ru.otus.appaccounts.service.AccountService;
import ru.otus.common.dto.AccountDto;

import java.util.List;


@Tag(
        name = "Account API",
        description = "Api for accounts"
)
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @GetMapping("/account")
    public List<AccountDto> getAll() {
        return
                accountService.getAll()
                        .stream()
                        .map(Account::toDto)
                        .toList();
    }


    @GetMapping("/account/{num}")
    public AccountDto getByNum(
            @Parameter(description = "account num", required = true) @PathVariable("num") String num) {
        Account account = accountService.getByNum(num);
        return
                (account != null)
                        ? account.toDto()
                        : null;
    }


    @PutMapping("/account")
    public AccountDto update(@RequestBody AccountDto dto) {
        Account entity = Account.toEntity(dto);
        return accountService.save(entity).toDto();
    }
}
