package com.delivery.api.application.use_cases.address;

import com.delivery.api.application.service.AddressService;
import com.delivery.api.application.service.CityService;
import com.delivery.api.domain.entity.Address;
import com.delivery.api.infra.http.dto.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAddress {

    private final AddressService addressService;
    private final CityService cityService;

    @Autowired
    public CreateAddress(
            AddressService addressService,
            CityService cityService
    ){
            this.addressService = addressService;
            this.cityService = cityService;
    }

    public Address execute(AddressRequest addressRequest){
        Address address = AddressRequest.convertToEntity(addressRequest);
        this.cityService.findCity(address.getCity().getId());
        return this.addressService.createAddress(address);
    }

}
