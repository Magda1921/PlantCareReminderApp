package com.magdalenaszymura.plantcarereminderapp.service;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import com.magdalenaszymura.plantcarereminderapp.repository.PlantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlantServiceTest {

    @InjectMocks
    private PlantService plantService;
    @Mock
    private PlantRepository plantRepository;

    @Test
    public void shouldAddAFlower() {
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
        String userEmail = "ann@gmail.com";
        String password = "password";
        account.setId(accountId);
        account.setUserName(userName);
        account.setEmail(userEmail);
        account.setPassword(password);

        when(plantRepository.save(plant)).thenReturn(plant);
//        when
        plantService.addFlower(plant, account);
//        then
        verify(plantRepository).save(plant);
    }
}
