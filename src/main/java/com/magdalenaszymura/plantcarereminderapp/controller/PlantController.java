package com.magdalenaszymura.plantcarereminderapp.controller;

import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import com.magdalenaszymura.plantcarereminderapp.service.PlantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class PlantController {

    private PlantService plantService;

    @GetMapping("/hello")
    public String greed() {
        return "Hello";
    }

    @PostMapping("/flowers")
    void registerNewPlant(@RequestBody Plant plant) {
        plantService.addFlower(plant);
    }
}
