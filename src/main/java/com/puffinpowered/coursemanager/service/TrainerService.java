package com.puffinpowered.coursemanager.service;

import com.puffinpowered.coursemanager.domain.Trainer;

import java.util.List;

/**
 * Created by pshields on 12/04/2017.
 */
public interface TrainerService {

    Trainer save(Trainer trainer);

    Trainer findOne(int i);

    List<Trainer> findByName(String name);

    List<Trainer> findByNameContaining(String name);
}
