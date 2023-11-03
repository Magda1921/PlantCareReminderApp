package com.magdalenaszymura.plantcarereminderapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int wateringEveryXDays;

    @ManyToOne
    @JoinColumn(name = "plantId")
    private AccountPlant accountPlant;
}
