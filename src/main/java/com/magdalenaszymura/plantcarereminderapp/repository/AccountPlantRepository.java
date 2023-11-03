package com.magdalenaszymura.plantcarereminderapp.repository;

import com.magdalenaszymura.plantcarereminderapp.model.AccountPlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountPlantRepository
        extends JpaRepository<AccountPlant, Long> {

}
