package com.delivery.api.application.use_cases.city;

import com.delivery.api.application.service.CityService;
import com.delivery.api.application.service.StateService;
import com.delivery.api.domain.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCity {

    private final CityService cityService;
    private final StateService stateService;

    @Autowired
    public CreateCity(
            CityService cityService,
            StateService stateService
    ){
            this.cityService = cityService;
            this.stateService = stateService;
    }

    public City execute(City city){
        this.stateService.findState(city.getState().getId());
        return this.cityService.createCity(city);
    }

}
