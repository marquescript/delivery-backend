package com.delivery.api.domain.providers;

import java.util.List;

public interface AddressProvider {

    public List<String> searchAddresses(String query);

}
