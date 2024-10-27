package com.delivery.api.application.use_cases.state;

import com.delivery.api.application.service.StateService;
import com.delivery.api.domain.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateState {

    private final StateService stateService;

    @Autowired
    public CreateState(
            StateService stateService
    ){
            this.stateService = stateService;
    }

    public State execute(State state){
        return this.stateService.createState(state);
    }

}
