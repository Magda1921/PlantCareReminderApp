package com.magdalenaszymura.plantcarereminderapp.controller;

import com.magdalenaszymura.plantcarereminderapp.model.Account;
import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import com.magdalenaszymura.plantcarereminderapp.service.AccountService;
import com.magdalenaszymura.plantcarereminderapp.service.PlantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class PlantController {

    private PlantService plantService;
    private AccountService accountService;

    @GetMapping("/hello")
    public String greed() {
        return "Hello";
    }

    @PostMapping("/flowers/{email}")
    void registerNewPlant(@PathVariable("email") String email, @RequestBody Plant plant) {
        Account account = accountService.getAccountByEmail(email);
        plantService.addFlower(plant, account);
    }
}
