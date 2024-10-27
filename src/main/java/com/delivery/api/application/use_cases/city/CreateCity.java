package com.delivery.api.application.use_cases.city;

import com.delivery.api.application.service.CityService;
import com.delivery.api.domain.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCity {

    private final CityService cityService;

    @Autowired
    public CreateCity(
            CityService cityService
    ){
            this.cityService = cityService;
    }

    public City execute(City city){
        return this.cityService.createCity(city);
    }

}
