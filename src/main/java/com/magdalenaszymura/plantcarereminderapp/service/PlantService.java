package com.magdalenaszymura.plantcarereminderapp.service;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.model.AccountPlant;
import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import com.magdalenaszymura.plantcarereminderapp.repository.AccountPlantRepository;
import com.magdalenaszymura.plantcarereminderapp.repository.AccountRepository;
import com.magdalenaszymura.plantcarereminderapp.repository.PlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class PlantService {
    private final PlantRepository plantRepository;
    private AccountRepository accountRepository;
    private AccountPlantRepository accountPlantRepository;
    public void addFlower(Plant plant) {
        Account john = new Account(null, "Maria");
        Account saveAccount = accountRepository.save(john);
        Plant savePlant = plantRepository.save(plant);
        AccountPlant accountPlant = new AccountPlant(null, 5, new Date(2023, Calendar.OCTOBER, 30), new Date(2023, Calendar.NOVEMBER, 4), saveAccount, List.of(savePlant));
        plant.setAccountPlant(accountPlant);
        accountPlantRepository.save(accountPlant);

    }
}
