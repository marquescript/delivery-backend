package com.delivery.api.application.use_cases._factory;

import com.delivery.api.application.use_cases.kitchen.*;
import com.delivery.api.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KitchenUseCase {

    private final FindKitchen findKitchen;
    private final FindAllKitchens findAllKitchens;
    private final CreateKitchen createKitchen;
    private final UpdateKitchen updateKitchen;
    private final DeleteKitchen deleteKitchen;

    @Autowired
    public KitchenUseCase(
            FindKitchen findKitchen,
            FindAllKitchens findAllKitchens,
            CreateKitchen createKitchen,
            UpdateKitchen updateKitchen,
            DeleteKitchen deleteKitchen
    ){
            this.findKitchen = findKitchen;
            this.findAllKitchens = findAllKitchens;
            this.createKitchen = createKitchen;
            this.updateKitchen = updateKitchen;
            this.deleteKitchen = deleteKitchen;
    }

    public Kitchen findKitchenUseCase(Long kitchenId){
        return this.findKitchen.execute(kitchenId);
    }

    public List<Kitchen> findAllKitchensUseCase(int page, int size){
        return this.findAllKitchens.execute(page, size);
    }

    public Kitchen createKitchenUseCase(Kitchen kitchen){
        return this.createKitchen.execute(kitchen);
    }

    public Kitchen updateKitchenUseCase(Long kitchenId, Kitchen kitchen){
        return this.updateKitchen.execute(kitchenId, kitchen);
    }

    public void deleteKitchenUseCase(Long kitchenId){
        this.deleteKitchen.execute(kitchenId);
    }

}
