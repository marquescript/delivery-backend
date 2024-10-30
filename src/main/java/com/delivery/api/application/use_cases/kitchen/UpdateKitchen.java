package com.delivery.api.application.use_cases.kitchen;

import com.delivery.api.application.service.KitchenService;
import com.delivery.api.domain.entity.Kitchen;
import com.delivery.api.infra.http.dto.KitchenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateKitchen {

    private final KitchenService kitchenService;

    @Autowired
    public UpdateKitchen(
            KitchenService kitchenService
    ){
        this.kitchenService = kitchenService;
    }

    public Kitchen execute(Long kitchenId, KitchenRequest kitchenRequest){
        Kitchen kitchen = KitchenRequest.convertDtoToEntity(kitchenRequest);
        return this.kitchenService.updateKitchen(kitchenId, kitchen);
    }

}
