package com.delivery.api.domain.providers;

import java.util.List;
import java.util.Optional;

public interface AddressProvider {

    public List<String> searchAddresses(String query);
    Optional<String> getAddressFromCoordinates(double latitude, double longitude);

}
