package com.delivery.api.application.service;

import com.delivery.api.domain.entity.Kitchen;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.repository.KitchenRepository;
import com.delivery.api.infra.persistence.jpa_entity.KitchenPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitchenService {

    private final KitchenRepository<KitchenPersistence> kitchenRepository;

    @Autowired
    public KitchenService(
            @Qualifier("jpa") KitchenRepository<KitchenPersistence> kitchenRepository
    ){
            this.kitchenRepository = kitchenRepository;
    }


    public Kitchen findKitchen(Long kitchenId){
        KitchenPersistence kitchenPersistence = this.kitchenRepository.findById(kitchenId).orElseThrow(() -> new EntityNotFound("Kitchen not found"));
        return KitchenPersistence.convertKitchenPersistenceToKitchen(kitchenPersistence);
    }

    public List<Kitchen> findAllKitchens(int page, int size){
        List<KitchenPersistence> kitchenPersistences = this.kitchenRepository.findAll(page, size);
        return kitchenPersistences.stream().map(KitchenPersistence::convertKitchenPersistenceToKitchen).toList();
    }

}
