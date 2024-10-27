package com.delivery.api.application.service;

import com.delivery.api.domain.entity.Address;
import com.delivery.api.domain.repository.AddressRepository;
import com.delivery.api.infra.persistence.jpa_entity.AddressPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository<AddressPersistence> addressRepository;

    @Autowired
    public AddressService(
            @Qualifier("jpa") AddressRepository<AddressPersistence> addressRepository
    ) {
            this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address){
        AddressPersistence addressPersistence = AddressPersistence.convertAddressToAddressPersistence(address);
        addressPersistence = this.addressRepository.save(addressPersistence);
        return AddressPersistence.convertAddressPersistenceToAddress(addressPersistence);
    }

}
