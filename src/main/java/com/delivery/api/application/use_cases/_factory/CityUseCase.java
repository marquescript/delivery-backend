package com.delivery.api.application.use_cases._factory;

import com.delivery.api.application.use_cases.city.CreateCity;
import com.delivery.api.application.use_cases.city.FindAllCities;
import com.delivery.api.application.use_cases.city.FindCity;
import com.delivery.api.domain.entity.City;
import com.delivery.api.infra.http.dto.CityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityUseCase {

    private final CreateCity createCity;
    private final FindCity findCity;
    private final FindAllCities findAllCities;

    @Autowired
    public CityUseCase(
            CreateCity createCity,
            FindCity findCity,
            FindAllCities findAllCities
    ){
            this.createCity = createCity;
            this.findCity = findCity;
            this.findAllCities = findAllCities;
    }

    public City createCityUseCase(CityRequest cityRequest){
        return this.createCity.execute(cityRequest);
    }

    public City findCityUseCase(Long id){
        return this.findCity.execute(id);
    }

    public List<City> findAllCitiesUseCase(int page, int size){
        return this.findAllCities.execute(page, size);
    }

}
