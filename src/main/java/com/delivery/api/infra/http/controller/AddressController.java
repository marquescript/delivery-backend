package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.AddressUseCase;
import com.delivery.api.domain.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressUseCase addressUseCase;

    @Autowired
    public AddressController(
            AddressUseCase addressUseCase
    ){
            this.addressUseCase = addressUseCase;
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        address = this.addressUseCase.createAddressUseCase(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

}
