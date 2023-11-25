package com.magdalenaszymura.plantcarereminderapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import com.magdalenaszymura.plantcarereminderapp.service.AccountService;
import com.magdalenaszymura.plantcarereminderapp.service.PlantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlantController.class)
public class PlantControllerTest {
    @MockBean
    private PlantService plantService;
    @MockBean
    private AccountService accountService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

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


        given(accountService.getAccountByEmail(userEmail)).willReturn(account);
        doNothing().when(plantService).addFlower(plant, account);
//        when
        this.mockMvc.perform(MockMvcRequestBuilders.post("/flowers/{email}", userEmail).
                contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(plant))).
//                then
        andExpect(status().isOk());

    }

    @Test
    public void shouldNotRegisterNewPlant() throws Exception {
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


        given(accountService.getAccountByEmail(userEmail)).willReturn(account);
        doNothing().when(plantService).addFlower(plant, account);
//        when
        this.mockMvc.perform(MockMvcRequestBuilders.post("/flowers/{email}", userEmail).
                contentType(MediaType.APPLICATION_PDF)
                .content(objectMapper.writeValueAsString(plant))).
//                then
        andExpect(status().is4xxClientError());

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

        given(plantService.findPlantByName(name)).willReturn(plant);
//        when
        this.mockMvc.perform(MockMvcRequestBuilders.get("/flowers/{name}", name)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(plant)))
//        then
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldReturnNotFoundIfThePlantDoesNotExist() throws Exception {
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

        String plantName = "daisy";

        given(plantService.findPlantByName(plantName)).willReturn(plant);
//        when
        this.mockMvc.perform(MockMvcRequestBuilders.get("/flowers/{name}", name)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(plant)))
//        then
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
