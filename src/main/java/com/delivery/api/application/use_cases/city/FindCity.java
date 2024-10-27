package com.delivery.api.application.use_cases.city;

import com.delivery.api.application.service.CityService;
import com.delivery.api.domain.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindCity {

    private final CityService cityService;

    @Autowired
    public FindCity(
            CityService cityService
    ){
        this.cityService = cityService;
    }

    public City execute(Long cityId){
        return this.cityService.findCity(cityId);
    }

}
