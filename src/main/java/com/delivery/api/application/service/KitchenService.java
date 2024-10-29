package com.delivery.api.application.service;

import com.delivery.api.domain.entity.Kitchen;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.repository.KitchenRepository;
import com.delivery.api.infra.persistence.jpa_entity.KitchenPersistence;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Kitchen createKitchen(Kitchen kitchen){
        KitchenPersistence kitchenPersistence = KitchenPersistence.convertKitchenToKitchenPersistence(kitchen);
        kitchenPersistence = this.kitchenRepository.save(kitchenPersistence);
        return KitchenPersistence.convertKitchenPersistenceToKitchen(kitchenPersistence);
    }

    @Transactional
    public Kitchen updateKitchen(Long kitchenId, Kitchen kitchen){
        this.findKitchen(kitchenId);
        kitchen.setId(kitchenId);
        KitchenPersistence kitchenPersistence = KitchenPersistence.convertKitchenToKitchenPersistence(kitchen);
        kitchenPersistence = this.kitchenRepository.save(kitchenPersistence);
        return KitchenPersistence.convertKitchenPersistenceToKitchen(kitchenPersistence);
    }

    @Transactional
    public void deleteKitchen(Long kitchenId){
        this.findKitchen(kitchenId);
        this.kitchenRepository.deleteById(kitchenId);
    }

}
