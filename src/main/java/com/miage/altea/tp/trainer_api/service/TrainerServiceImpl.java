package com.miage.altea.tp.trainer_api.service;

import com.miage.altea.tp.trainer_api.bo.Trainer;
import com.miage.altea.tp.trainer_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Iterable<Trainer> getAllTrainers() {
        return this.trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(String name) {
        return this.trainerRepository.findById(name).orElse(null);
    }

    @Transactional
    @Override
    public Trainer createTrainer(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Transactional
    @Override
    public void deleteTrainer(String name) {
        this.trainerRepository.deleteByName(name);
    }
}

