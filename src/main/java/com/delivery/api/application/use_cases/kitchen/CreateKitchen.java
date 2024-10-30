package com.delivery.api.application.use_cases.kitchen;

import com.delivery.api.application.service.KitchenService;
import com.delivery.api.domain.entity.Kitchen;
import com.delivery.api.infra.http.dto.KitchenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateKitchen {

    private final KitchenService kitchenService;

    @Autowired
    public CreateKitchen(
            KitchenService kitchenService
    ){
        this.kitchenService = kitchenService;
    }

    public Kitchen execute(KitchenRequest kitchenRequest){
        Kitchen kitchen = KitchenRequest.convertDtoToEntity(kitchenRequest);
        return this.kitchenService.createKitchen(kitchen);
    }

}
