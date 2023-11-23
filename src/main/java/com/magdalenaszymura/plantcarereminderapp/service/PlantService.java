package com.magdalenaszymura.plantcarereminderapp.service;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import com.magdalenaszymura.plantcarereminderapp.repository.PlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PlantService {
    private final PlantRepository plantRepository;

    public void addFlower(Plant plant, Account account) {
        plant.setAccount(account);
        plantRepository.save(plant);
    }

    public Plant findPlantByName(String name) {
        Plant plant = plantRepository.getPlantByName(name);
        return plant;
    }
}
