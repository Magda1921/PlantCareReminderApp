package com.magdalenaszymura.plantcarereminderapp.controller;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;
    @PostMapping("/accounts")
    void registerNewAccount(@RequestBody Account account) {
        accountService.addAccount(account);
    }

}
