package com.magdalenaszymura.plantcarereminderapp.repository;

import com.magdalenaszymura.plantcarereminderapp.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlantRepository
        extends JpaRepository<Plant, Long> {
    Plant getPlantByName (String name);

}
