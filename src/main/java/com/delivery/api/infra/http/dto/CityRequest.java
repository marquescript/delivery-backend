package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.City;
import com.delivery.api.domain.entity.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CityRequest(
        Long id,
        @NotBlank
        String name,
        @NotNull
        StateRequest state
){

    public static City convertDtoToEntity(CityRequest cityRequest){
        return new City(
                cityRequest.id,
                cityRequest.name,
                StateRequest.convertDtoToEntity(cityRequest.state)
        );
    }

}
