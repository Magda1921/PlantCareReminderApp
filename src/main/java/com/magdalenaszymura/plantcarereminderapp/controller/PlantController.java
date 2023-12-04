package com.magdalenaszymura.plantcarereminderapp.controller;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import com.magdalenaszymura.plantcarereminderapp.service.AccountService;
import com.magdalenaszymura.plantcarereminderapp.service.PlantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class PlantController {

    private PlantService plantService;
    private AccountService accountService;

    @PostMapping("/flowers/{email}")
    void registerNewPlant(@PathVariable("email") String email, @RequestBody Plant plant) {
        Account account = accountService.getAccountByEmail(email);
        plantService.addFlower(plant, account);
    }

    @GetMapping("/flowers")
    @ResponseBody
    ResponseEntity<Plant> getPlantByName(@RequestParam String name) {
        Plant plant = plantService.findPlantByName(name);

        if (plant != null) {
            return ResponseEntity.ok(plant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/flowers/{wateringFrequency}")
    @ResponseBody
    ResponseEntity<List<Plant>> findPlantByWateringFrequency(@PathVariable int wateringFrequency) {
        List<Plant> plants = plantService.findPlantByWateringFrequency(wateringFrequency);

        return ResponseEntity.ok(plants);
    }
    @DeleteMapping("/flowers")
    @ResponseBody
    void deletePlant(@RequestBody Plant plant) {
        plantService.deletePlant(plant);
    }
}
