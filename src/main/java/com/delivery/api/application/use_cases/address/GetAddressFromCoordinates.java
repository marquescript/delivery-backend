package com.delivery.api.application.use_cases.address;

import com.delivery.api.domain.providers.AddressProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetAddressFromCoordinates {

    private final AddressProvider addressProvider;

    @Autowired
    public GetAddressFromCoordinates(
            @Qualifier("google-client") AddressProvider addressProvider
    ){
            this.addressProvider = addressProvider;
    }

    public Optional<String> execute(double latitude, double longitude){
        return this.addressProvider.getAddressFromCoordinates(latitude, longitude);
    }

}
