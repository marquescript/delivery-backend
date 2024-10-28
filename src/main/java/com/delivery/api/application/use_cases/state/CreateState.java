package com.delivery.api.application.use_cases.state;

import com.delivery.api.application.service.StateService;
import com.delivery.api.domain.entity.State;
import com.delivery.api.infra.http.dto.StateRequest;
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

    public State execute(StateRequest stateRequest){
        State state = StateRequest.convertDtoToEntity(stateRequest);
        return this.stateService.createState(state);
    }

}
