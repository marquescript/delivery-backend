package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.State;
import com.delivery.api.infra.http.handler.validation.GroupsValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StateRequest(

        @NotNull(groups = GroupsValidation.GetStateId.class)
        Long id,

        @NotBlank
        String name
){

    public static State convertDtoToEntity(StateRequest stateRequest){
        return new State(
                stateRequest.id(),
                stateRequest.name()
        );
    }

}
