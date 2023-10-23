package com.example.plantcarereminderapp;

import com.example.plantcarereminderapp.model.Account;
import com.example.plantcarereminderapp.model.AccountPlant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class PlantCareReminderAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantCareReminderAppApplication.class, args);
    }

}
