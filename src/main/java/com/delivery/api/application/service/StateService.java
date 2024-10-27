package com.delivery.api.application.service;

import com.delivery.api.domain.entity.State;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.repository.StateRepository;
import com.delivery.api.infra.persistence.jpa_entity.StatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    private final StateRepository<StatePersistence> stateRepository;

    @Autowired
    public StateService(
            @Qualifier("jpa") StateRepository<StatePersistence> stateRepository
    ){
            this.stateRepository = stateRepository;
    }

    public State findState(Long stateId){
        StatePersistence statePersistence = this.stateRepository.findById(stateId).orElseThrow(() -> new EntityNotFound("State not found"));
        return StatePersistence.convertStatePersistenceToState(statePersistence);
    }

    public State createState(State state){
        StatePersistence statePersistence = StatePersistence.convertStateToStatePersistence(state);
        statePersistence = this.stateRepository.save(statePersistence);
        return StatePersistence.convertStatePersistenceToState(statePersistence);
    }

}
