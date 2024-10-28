package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.CityUseCase;
import com.delivery.api.domain.entity.City;
import com.delivery.api.infra.http.dto.CityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody CityRequest cityRequest){
        City city = this.cityUseCase.createCityUseCase(cityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(city);
    }

}
