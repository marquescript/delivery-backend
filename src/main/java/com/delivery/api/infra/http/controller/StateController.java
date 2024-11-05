package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.StateUseCase;
import com.delivery.api.domain.entity.State;
import com.delivery.api.infra.http.dto.StateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/state")
@Tag(name = "State")
public class StateController {

    private final StateUseCase stateUseCase;

    @Autowired
    public StateController(
            StateUseCase stateUseCase
    ){
            this.stateUseCase = stateUseCase;
    }

    @Operation(summary = "Find a State")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "State found successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StateRequest.class))),
            @ApiResponse(responseCode = "400", description = "State not found", content = @Content())
    })
    @GetMapping("/{stateId}")
    public ResponseEntity<State> findState(@PathVariable Long stateId){
        State state = this.stateUseCase.findStateUseCase(stateId);
        return ResponseEntity.status(HttpStatus.OK).body(state);
    }

    @Operation(summary = "Create a new State", method = "POST")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Successfully created State", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StateRequest.class)))
    })
    @PostMapping
    public ResponseEntity<State> createState(@RequestBody StateRequest stateRequest){
        State state = this.stateUseCase.createStateUseCase(stateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(state);
    }

}
