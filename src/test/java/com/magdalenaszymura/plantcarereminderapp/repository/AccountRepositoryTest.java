package com.magdalenaszymura.plantcarereminderapp.repository;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    void shouldGetAccountByEmail() {
//        given
        Account account = new Account();
        long accountId = 1;
        String userName = "Maria";
        String userEmail = "ann@gmail.com";
        String password = "password";
        account.setId(accountId);
        account.setUserName(userName);
        account.setEmail(userEmail);
        account.setPassword(password);

        accountRepository.save(account);
//        when
        Account foundAccountByEmail = accountRepository.getAccountByEmail(userEmail);
//        then
        assertThat(foundAccountByEmail).isEqualTo(account);
    }

    @Test
    void shouldDoNotGetAccountByEmail() {
        Account account = new Account();
        long accountId = 1;
        String userName = "Maria";
        String userEmail = "ann@gmail.com";
        String password = "password";
        account.setId(accountId);
        account.setUserName(userName);
        account.setEmail(userEmail);
        account.setPassword(password);

        accountRepository.save(account);
//        when
        Account foundAccountByEmail = accountRepository.getAccountByEmail("email");
//        then
        assertThat(foundAccountByEmail).isNull();

    }
}

