package ru.otus.appaccounts.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.appaccounts.model.Account;
import ru.otus.appaccounts.repository.AccountRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;


    @Transactional(readOnly = true)
    public List<Account> getAll() {
        return accountRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Account getByNum(String num) {
        return
                accountRepository.findFirstByNum(num)
                .orElse(null);
    }


    @Transactional
    public Account save(Account item) {
        return accountRepository.save(item);
    }
}
