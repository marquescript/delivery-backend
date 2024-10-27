package com.delivery.api.application.use_cases._factory;

import com.delivery.api.application.use_cases.city.CreateCity;
import com.delivery.api.application.use_cases.city.FindCity;
import com.delivery.api.domain.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityUseCase {

    private final CreateCity createCity;
    private final FindCity findCity;

    @Autowired
    public CityUseCase(
            CreateCity createCity,
            FindCity findCity
    ){
            this.createCity = createCity;
            this.findCity = findCity;
    }

    public City createCityUseCase(City city){
        return this.createCity.execute(city);
    }

    public City findCityUseCase(Long id){
        return this.findCity.execute(id);
    }

}
