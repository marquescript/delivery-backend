package com.delivery.api.application.use_cases.address;

import com.delivery.api.application.service.AddressService;
import com.delivery.api.domain.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class CreateAddress {

    private final AddressService addressService;

    public CreateAddress(
            AddressService addressService
    ){
            this.addressService = addressService;
    }

    public Address execute(Address address){
        return this.addressService.createAddress(address);
    }

}
