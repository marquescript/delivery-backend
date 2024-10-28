package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.StateUseCase;
import com.delivery.api.domain.entity.State;
import com.delivery.api.infra.http.dto.StateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/state")
public class StateController {

    private final StateUseCase stateUseCase;

    @Autowired
    public StateController(
            StateUseCase stateUseCase
    ){
            this.stateUseCase = stateUseCase;
    }

    @PostMapping
    public ResponseEntity<State> createState(@RequestBody StateRequest stateRequest){
        State state = this.stateUseCase.createStateUseCase(stateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(state);
    }


}
