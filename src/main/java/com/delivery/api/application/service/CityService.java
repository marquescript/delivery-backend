package com.delivery.api.application.service;

import com.delivery.api.domain.entity.City;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.repository.CityRepository;
import com.delivery.api.infra.persistence.jpa_entity.CityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository<CityPersistence> cityRepository;

    @Autowired
    public CityService(
            @Qualifier("jpa") CityRepository<CityPersistence> cityRepository
    ){
            this.cityRepository = cityRepository;
    }

    public City createCity(City city){
        CityPersistence cityPersistence = CityPersistence.convertCityToCityPersistence(city);
        cityPersistence = this.cityRepository.save(cityPersistence);
        return CityPersistence.convertCityPersistenceToCity(cityPersistence);
    }

    public City findCity(Long cityId){
        CityPersistence cityPersistence = this.cityRepository.findById(cityId).orElseThrow(() -> new EntityNotFound("City not found"));
        return CityPersistence.convertCityPersistenceToCity(cityPersistence);
    }

    public List<City> findAllCities(int page, int size){
        List<CityPersistence> cityPersistences = this.cityRepository.findAll(page, size);
        return cityPersistences.stream().map(city -> CityPersistence.convertCityPersistenceToCity(city)).toList();
    }

}
