package com.delivery.api.application.use_cases.address;

import com.delivery.api.application.service.AddressService;
import com.delivery.api.domain.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddress {

    private final AddressService addressService;

    @Autowired
    public FindAddress(
            AddressService addressService
    ){
            this.addressService = addressService;
    }

    public Address execute(Long addressId){
        return this.addressService.findAddress(addressId);
    }

}
