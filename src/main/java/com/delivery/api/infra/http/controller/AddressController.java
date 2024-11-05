package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.AddressUseCase;
import com.delivery.api.domain.entity.Address;
import com.delivery.api.infra.external_services.GoogleMapsClient;
import com.delivery.api.infra.http.dto.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final GoogleMapsClient googlePlacesService;

    private final AddressUseCase addressUseCase;

    @Autowired
    public AddressController(
            AddressUseCase addressUseCase,
            GoogleMapsClient googlePlacesService
    ){
            this.addressUseCase = addressUseCase;
            this.googlePlacesService = googlePlacesService;
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody AddressRequest addressRequest){
        Address address = this.addressUseCase.createAddressUseCase(addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> findAddress(@PathVariable Long addressId){
        Address address = this.addressUseCase.findAddressUseCase(addressId);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @GetMapping("/place")
    public ResponseEntity<List<String>> findPlace(@RequestParam String query){
        List<String> result = this.googlePlacesService.searchAddresses(query);
        return ResponseEntity.ok(result);
    }
}
