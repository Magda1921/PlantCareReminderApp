package com.magdalenaszymura.plantcarereminderapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountPlant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private Date lastReminder;
    private Date NextReminder;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "accountPlant", cascade = {CascadeType.ALL})
    private List<Plant> plants;

}
