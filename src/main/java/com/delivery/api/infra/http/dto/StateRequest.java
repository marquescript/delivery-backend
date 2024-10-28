package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.State;
import jakarta.validation.constraints.NotBlank;

public record StateRequest(
        Long id,
        @NotBlank
        String name
){

    public static State convertDtoToEntity(StateRequest stateRequest){
        return new State(
                stateRequest.id,
                stateRequest.name
        );
    }

}
