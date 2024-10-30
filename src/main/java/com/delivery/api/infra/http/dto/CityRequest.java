package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.City;
import com.delivery.api.domain.entity.State;
import com.delivery.api.infra.http.handler.validation.GroupsValidation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

public record CityRequest(
        @NotNull(groups = GroupsValidation.GetCityId.class)
        Long id,

        @NotBlank
        String name,

        @Valid
        @ConvertGroup(from = Default.class, to = GroupsValidation.GetStateId.class)
        StateRequest state
){

    public static City convertDtoToEntity(CityRequest cityRequest){
        return new City(
                cityRequest.id(),
                cityRequest.name(),
                cityRequest.state() != null ? StateRequest.convertDtoToEntity(cityRequest.state()) : null
        );
    }

}
