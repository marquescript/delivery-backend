package com.delivery.api.application.use_cases.address;

import com.delivery.api.domain.providers.AddressProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchAddresses {

    private final AddressProvider addressProvider;

    public SearchAddresses(
            @Qualifier("google-client") AddressProvider addressProvider
    ){
            this.addressProvider = addressProvider;
    }

    public List<String> execute(String query){
        return this.addressProvider.searchAddresses(query);
    }

}
