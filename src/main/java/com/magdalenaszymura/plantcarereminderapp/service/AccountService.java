package com.magdalenaszymura.plantcarereminderapp.service;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public void addAccount(Account account) {
        Account saveAccount = accountRepository.save(account);
    }

    public Account getAccountByEmail(String accountEmail) {
        return accountRepository.getAccountByEmail(accountEmail);
    }
}
