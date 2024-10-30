package com.delivery.api.application.use_cases._factory;

import com.delivery.api.application.use_cases.address.CreateAddress;
import com.delivery.api.application.use_cases.address.FindAddress;
import com.delivery.api.domain.entity.Address;
import com.delivery.api.infra.http.dto.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressUseCase {

    private final CreateAddress createAddress;
    private final FindAddress findAddress;

    @Autowired
    public AddressUseCase(
            CreateAddress createAddress,
            FindAddress findAddress
    ){
            this.createAddress = createAddress;
            this.findAddress = findAddress;
    }

    public Address createAddressUseCase(AddressRequest addressRequest){
        return this.createAddress.execute(addressRequest);
    }

    public Address findAddressUseCase(Long addressId){
        return this.findAddress.execute(addressId);
    }

}
