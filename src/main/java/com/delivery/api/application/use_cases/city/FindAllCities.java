package com.delivery.api.application.use_cases.city;

import com.delivery.api.application.service.CityService;
import com.delivery.api.domain.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllCities {

    private final CityService cityService;

    @Autowired
    public FindAllCities(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> execute(int page, int size) {
        return this.cityService.findAllCities(page, size);
    }

}
