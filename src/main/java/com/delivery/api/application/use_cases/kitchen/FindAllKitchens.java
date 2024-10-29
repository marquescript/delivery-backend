package com.delivery.api.application.use_cases.kitchen;

import com.delivery.api.application.service.KitchenService;
import com.delivery.api.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllKitchens {

    private final KitchenService kitchenService;

    @Autowired
    public FindAllKitchens(
            KitchenService kitchenService
    ){
        this.kitchenService = kitchenService;
    }

    public List<Kitchen> execute(int page, int size){
        return this.kitchenService.findAllKitchens(page, size);
    }

}
