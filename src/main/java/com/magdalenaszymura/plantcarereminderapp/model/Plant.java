package com.magdalenaszymura.plantcarereminderapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    private String individualName;

    @Column(name = "watering_frequency", nullable = false)
    private int wateringFrequency;

    private Date lastWatering;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
