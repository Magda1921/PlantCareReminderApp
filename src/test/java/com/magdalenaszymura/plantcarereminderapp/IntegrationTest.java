package com.magdalenaszymura.plantcarereminderapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import com.magdalenaszymura.plantcarereminderapp.repository.AccountRepository;
import com.magdalenaszymura.plantcarereminderapp.repository.PlantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    PlantRepository plantRepository;
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void shouldRegisterNewPlant() throws Exception {
//        given
        Plant plant = new Plant();
        int id = 1;
        String name = "rose";
        String individualName = "rose1";
        int wateringFrequency = 5;
        plant.setId(id);
        plant.setName(name);
        plant.setWateringFrequency(wateringFrequency);
        plant.setIndividualName(individualName);

        Account account = new Account();
        long accountId = 1;
        String userName = "Maria";
        String userEmail = "maria@lp.com";
        String password = "password";
        account.setId(accountId);
        account.setUserName(userName);
        account.setEmail(userEmail);
        account.setPassword(password);

        accountRepository.save(account);

        plant.setAccount(account);
//        when
        mvc.perform(post("/flowers/{email}", userEmail)
                        .content(objectMapper.writeValueAsString(plant))
                        .contentType(MediaType.APPLICATION_JSON))
//         then
                .andExpect(status().isOk());
        List<String> plants = plantRepository.findAll()
                .stream()
                .map(Plant::getName)
                .filter("rose"::equals)
                .collect(Collectors.toList());
        assertThat(plants).hasSize(1);
    }

    @Test
    void shouldGetPlantByPlantName() throws Exception {
//        given
        Plant plant = new Plant();
        int id = 1;
        String name = "rose";
        String individualName = "rose1";
        int wateringFrequency = 5;
        plant.setId(id);
        plant.setName(name);
        plant.setWateringFrequency(wateringFrequency);
        plant.setIndividualName(individualName);

        Account account = new Account();
        long accountId = 1;
        String userName = "Maria";
        String userEmail = "maria@lp.com";
        String password = "password";
        account.setId(accountId);
        account.setUserName(userName);
        account.setEmail(userEmail);
        account.setPassword(password);

        accountRepository.save(account);

        plant.setAccount(account);
        plantRepository.save(plant);
//        when
        this.mvc.perform(get("/flowers")
                        .param("name", name))
                .andDo(print())
//        then
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetListOfPlantsByWateringFrequently() throws Exception {
//        given
        Plant plant = new Plant();
        int id = 1;
        String name = "rose";
        String individualName = "rose1";
        int wateringFrequency = 5;
        plant.setId(id);
        plant.setName(name);
        plant.setWateringFrequency(wateringFrequency);
        plant.setIndividualName(individualName);

        Account account = new Account();
        long accountId = 1;
        String userName = "Maria";
        String userEmail = "maria@lp.com";
        String password = "password";
        account.setId(accountId);
        account.setUserName(userName);
        account.setEmail(userEmail);
        account.setPassword(password);

        accountRepository.save(account);

        plant.setAccount(account);
        plantRepository.save(plant);
//        when
        this.mvc
                .perform(get("/flowers/{wateringFrequency}", wateringFrequency))
                .andDo(print())
//        then
                .andExpect(status().isOk());

        List<String> plants = plantRepository.getPlantByWateringFrequency(wateringFrequency)
                .stream()
                .map(Plant::getName)
                .filter("rose"::equals)
                .collect(Collectors.toList());
        assertThat(plants).hasSize(1);
    }

    @Test
    void shouldDeletePlantFromDb() throws Exception {
//        given
        Plant plant = new Plant();
        int id = 1;
        String name = "rose";
        String individualName = "rose1";
        int wateringFrequency = 5;
        plant.setId(id);
        plant.setName(name);
        plant.setWateringFrequency(wateringFrequency);
        plant.setIndividualName(individualName);

        Account account = new Account();
        long accountId = 1;
        String userName = "Maria";
        String userEmail = "maria@lp.com";
        String password = "password";
        account.setId(accountId);
        account.setUserName(userName);
        account.setEmail(userEmail);
        account.setPassword(password);

        accountRepository.save(account);

        plant.setAccount(account);
        plantRepository.save(plant);
//        when
        this.mvc
                .perform(delete("/flowers")
                .content(objectMapper.writeValueAsString(plant))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
//        then
                .andExpect(status().isOk());

        List<String> plants = plantRepository.findAll()
                .stream()
                .map(Plant::getName)
                .filter("rose"::equals)
                .collect(Collectors.toList());
        assertThat(plants).hasSize(0);
    }
}

