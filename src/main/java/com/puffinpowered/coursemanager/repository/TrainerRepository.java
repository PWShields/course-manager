package com.puffinpowered.coursemanager.repository;

import com.puffinpowered.coursemanager.domain.Trainer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by pshields on 12/04/2017.
 */
public interface TrainerRepository extends CrudRepository<Trainer, Long> {
    List<Trainer> findByName(String name);

    List<Trainer> findByNameIgnoreCaseContaining(String name);
}
