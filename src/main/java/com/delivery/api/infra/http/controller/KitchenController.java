package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.KitchenUseCase;
import com.delivery.api.domain.entity.Kitchen;
import com.delivery.api.infra.http.dto.KitchenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitchen")
public class KitchenController {

    private final KitchenUseCase kitchenUseCase;

    @Autowired
    public KitchenController(
            KitchenUseCase kitchenUseCase
    ){
            this.kitchenUseCase = kitchenUseCase;
    }

    @GetMapping("/{kitchenId}")
    public ResponseEntity<Kitchen> findKitchen(@PathVariable Long kitchenId){
        Kitchen kitchen = this.kitchenUseCase.findKitchenUseCase(kitchenId);
        return ResponseEntity.status(HttpStatus.OK).body(kitchen);
    }

    @GetMapping
    public ResponseEntity<List<Kitchen>> findAllKitchens(@RequestParam(value = "page", defaultValue = "0") int page,
                                                         @RequestParam(value = "size", defaultValue = "10") int size){
        List<Kitchen> kitchens = this.kitchenUseCase.findAllKitchensUseCase(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(kitchens);
    }

    @PostMapping
    public ResponseEntity<Kitchen> saveKitchen(@RequestBody KitchenRequest kitchenRequest){
        Kitchen savedKitchen = this.kitchenUseCase.createKitchenUseCase(kitchenRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedKitchen);
    }

    @PutMapping("/{kitchenId}")
    public ResponseEntity<Kitchen> updateKitchen(@PathVariable Long kitchenId, @RequestBody KitchenRequest kitchenRequest){
        Kitchen updatedKitchen = this.kitchenUseCase.updateKitchenUseCase(kitchenId, kitchenRequest);
        return ResponseEntity.status(HttpStatus.OK).body(updatedKitchen);
    }

    @DeleteMapping("/{kitchenId}")
    public ResponseEntity<Void> deleteKitchen(@PathVariable Long kitchenId){
        this.kitchenUseCase.deleteKitchenUseCase(kitchenId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
