package com.magdalenaszymura.plantcarereminderapp.service;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.repository.AccountRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AccountServiceTest {
    private AccountService accountService;
    private AccountRepository accountRepository;

//    todo: zmienić bez beforeAll
    @BeforeAll
    public void setUp() {
        accountRepository = mock(AccountRepository.class);

        accountService = new AccountService(accountRepository);
    }

    @Test
    public void shouldAddAccount() {
//        given
        Account account = new Account();
        long id = 1;
        String userName = "Maria";
        String email = "maria@wp.com";
        String password = "password";
        account.setId(id);
        account.setUserName(userName);
        account.setEmail(email);
        account.setPassword(password);

        when(accountRepository.save(account)).thenReturn(account);
//        when
        accountService.addAccount(account);
//        then
        verify(accountRepository).save(account);
    }
}
