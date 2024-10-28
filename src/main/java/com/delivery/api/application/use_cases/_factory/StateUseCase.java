package com.delivery.api.application.use_cases._factory;

import com.delivery.api.application.use_cases.state.CreateState;
import com.delivery.api.application.use_cases.state.FindState;
import com.delivery.api.domain.entity.State;
import com.delivery.api.infra.http.dto.StateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateUseCase {

    private final CreateState createState;
    private final FindState findState;

    @Autowired
    public StateUseCase(
            CreateState createState,
            FindState findState
    ){
            this.createState = createState;
            this.findState = findState;
    }

    public State createStateUseCase(StateRequest stateRequest){
        return this.createState.execute(stateRequest);
    }

    public State findStateUseCase(Long stateId){
        return this.findState.execute(stateId);
    }

}
