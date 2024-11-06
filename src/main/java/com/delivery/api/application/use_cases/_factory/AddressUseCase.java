package com.delivery.api.application.use_cases._factory;

import com.delivery.api.application.use_cases.address.CreateAddress;
import com.delivery.api.application.use_cases.address.FindAddress;
import com.delivery.api.application.use_cases.address.GetAddressFromCoordinates;
import com.delivery.api.application.use_cases.address.SearchAddresses;
import com.delivery.api.domain.entity.Address;
import com.delivery.api.infra.http.dto.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AddressUseCase {

    private final CreateAddress createAddress;
    private final FindAddress findAddress;
    private final SearchAddresses searchAddresses;
    GetAddressFromCoordinates getAddressFromCoordinates;

    @Autowired
    public AddressUseCase(
            CreateAddress createAddress,
            FindAddress findAddress,
            SearchAddresses searchAddresses,
            GetAddressFromCoordinates getAddressFromCoordinates
    ){
            this.createAddress = createAddress;
            this.findAddress = findAddress;
            this.searchAddresses = searchAddresses;
            this.getAddressFromCoordinates = getAddressFromCoordinates;
    }

    public Address createAddressUseCase(AddressRequest addressRequest){
        return this.createAddress.execute(addressRequest);
    }

    public Address findAddressUseCase(Long addressId){
        return this.findAddress.execute(addressId);
    }

    public List<String> searchAddressesUseCase(String query){
        return this.searchAddresses.execute(query);
    }

    public Optional<String> getAddressFromCoordinatesUseCase(double latitude, double longitude){
        return this.getAddressFromCoordinates.execute(latitude, longitude);
    }

}
