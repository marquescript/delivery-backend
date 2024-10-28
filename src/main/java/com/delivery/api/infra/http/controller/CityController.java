package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.CityUseCase;
import com.delivery.api.domain.entity.City;
import com.delivery.api.infra.http.dto.CityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityUseCase cityUseCase;

    @Autowired
    public CityController(
            CityUseCase cityUseCase
    ){
            this.cityUseCase = cityUseCase;
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<City> findCity(@PathVariable Long cityId){
        City city = this.cityUseCase.findCityUseCase(cityId);
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

    @GetMapping
    public ResponseEntity<List<City>> findAllCities(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size){
        List<City> cities = this.cityUseCase.findAllCitiesUseCase(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(cities);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody CityRequest cityRequest){
        City city = this.cityUseCase.createCityUseCase(cityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(city);
    }

}
