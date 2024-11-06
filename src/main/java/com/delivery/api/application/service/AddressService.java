package com.delivery.api.application.service;

import com.delivery.api.domain.entity.Address;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.providers.AddressProvider;
import com.delivery.api.domain.repository.AddressRepository;
import com.delivery.api.infra.persistence.jpa_entity.AddressPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository<AddressPersistence> addressRepository;
    private final AddressProvider addressProvider;

    @Autowired
    public AddressService(
            @Qualifier("jpa") AddressRepository<AddressPersistence> addressRepository,
            @Qualifier("google-client") AddressProvider addressProvider
    ) {
            this.addressRepository = addressRepository;
            this.addressProvider = addressProvider;
    }

    public Address createAddress(Address address){
        AddressPersistence addressPersistence = AddressPersistence.convertAddressToAddressPersistence(address);
        addressPersistence = this.addressRepository.save(addressPersistence);
        return AddressPersistence.convertAddressPersistenceToAddress(addressPersistence);
    }

    public Address findAddress(Long addressId){
        AddressPersistence addressPersistence = this.addressRepository.findById(addressId).orElseThrow(() -> new EntityNotFound("Address not found"));
        return AddressPersistence.convertAddressPersistenceToAddress(addressPersistence);
    }

    // Fórmula de Haversine para calcular a distância entre duas coordenadas geográficas
    public Double calculateDsitanceBetweenTwoCoordinates(Double latitude1, Double longitude1, Double latitude2, Double longitude2){
        final int RAIO = 6371;

        double latitudeDistance = Math.toRadians(latitude2 - latitude1);
        double longitudeDistance = Math.toRadians(longitude2 - longitude1);
        double a = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2) + Math.cos(Math.toRadians(latitude1))
                * Math.cos(Math.toRadians(latitude2)) * Math.sin(longitudeDistance / 2) * Math.sin(longitudeDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RAIO * c;
    }

}
