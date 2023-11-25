package com.magdalenaszymura.plantcarereminderapp.service;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.repository.AccountRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
    @InjectMocks
    AccountService accountService;
    @Mock
    AccountRepository accountRepository;

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
