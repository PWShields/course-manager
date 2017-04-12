package com.puffinpowered.coursemanager.service;

import com.puffinpowered.coursemanager.domain.Trainer;
import com.puffinpowered.coursemanager.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pshields on 12/04/2017.
 */
@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public Trainer save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public Trainer findOne(int trainerId) {
        return trainerRepository.findOne(Integer.toUnsignedLong(trainerId));
    }

    @Override
    public List<Trainer> findByName(String name) {
        List<Trainer> trainer = trainerRepository.findByName(name);
        return trainer;
    }

    @Override
    public List<Trainer> findByNameContaining(String name) {
        return trainerRepository.findByNameIgnoreCaseContaining(name);
    }
}
