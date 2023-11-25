package com.magdalenaszymura.plantcarereminderapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {
    @MockBean
    AccountService accountService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRegisterNewPlant() throws Exception {
//        given
        Account account = new Account();
        long accountId = 1;
        String userName = "Maria";
        String userEmail = "maria@lp.com";
        String password = "password";
        account.setId(accountId);
        account.setUserName(userName);
        account.setEmail(userEmail);
        account.setPassword(password);

        doNothing().when(accountService).addAccount(account);
//        when
        this.mockMvc.perform(MockMvcRequestBuilders.post("/accounts").
                contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(account))).
//                then
        andExpect(status().isOk());
    }
}
