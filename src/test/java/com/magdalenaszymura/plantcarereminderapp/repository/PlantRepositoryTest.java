package com.magdalenaszymura.plantcarereminderapp.repository;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PlantRepositoryTest {
    @Autowired
    PlantRepository plantRepository;
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void shouldReturnAllPlantFromDb() {
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

        accountRepository.save(account);
        plant.setAccount(account);

        plantRepository.save(plant);
        List<Plant> plants = List.of(plant);
//        when
        List<Plant> all = plantRepository.findAll();
//        then
        assertThat(all).isNotEmpty();
        assertThat(all).hasSameElementsAs(plants);
    }

    @Test
    void shouldGetPlantByName() {
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

        accountRepository.save(account);
        plant.setAccount(account);

        plantRepository.save(plant);
//        when
        Plant foundPlantByName = plantRepository.getPlantByName(name);
//        then
        assertThat(foundPlantByName).isEqualTo(plant);
    }

    @Test
    void shouldDoNotGetPlantByName() {
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

        accountRepository.save(account);
        plant.setAccount(account);

        plantRepository.save(plant);
//        when
        Plant foundPlantByName = plantRepository.getPlantByName("daisy");
//        then
        assertThat(foundPlantByName).isNull();

    }
    @Test
    void shouldGetListOfPlantsByWateringFrequency() {
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

        accountRepository.save(account);
        plant.setAccount(account);

        plantRepository.save(plant);
        List<Plant> listOfPlants = List.of(plant);
//        when
        List <Plant> plants= plantRepository.getPlantByWateringFrequency(wateringFrequency);
//        then
        assertThat(plants).isEqualTo(listOfPlants);
    }
}
