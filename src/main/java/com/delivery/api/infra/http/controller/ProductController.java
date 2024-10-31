package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.ProductUseCase;
import com.delivery.api.domain.entity.Product;
import com.delivery.api.infra.http.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class ProductController {

    private final ProductUseCase productUseCase;

    @Autowired
    public ProductController(
            ProductUseCase productUseCase
    ){
            this.productUseCase = productUseCase;
    }

    @GetMapping("/{restaurantId}/product/{productId}")
    public ResponseEntity<Product> findProductByRestaurant(Long restaurantId, Long productId){
        Product product = this.productUseCase.findProductByRestaurantUseCase(restaurantId, productId);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/{restaurantId}/product")
    public ResponseEntity<List<Product>> findProductsByRestaurant(@PathVariable Long restaurantId, @RequestParam(value = "page", defaultValue = "0") int page,
                                                                  @RequestParam(value = "page", defaultValue = "0") int size){
        List<Product> products = this.productUseCase.findProductsByRestaurantUseCase(restaurantId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{restaurantId}/product/seach")
    public ResponseEntity<List<Product>> findProductsByRestaurantAndName(@PathVariable Long restaurantId, @RequestParam(value = "product-name") String productName, @RequestParam(value = "page", defaultValue = "0") int page,
                                                                  @RequestParam(value = "page", defaultValue = "0") int size){
        List<Product> products = this.productUseCase.findProductsByRestaurantAndNameUseCase(restaurantId, productName, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping("/{restaurantId}/product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest){
        Product product = this.productUseCase.createProductUseCase(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping("/{restaurantId}/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long restaurantId, @PathVariable Long productId){
        this.productUseCase.deleteProductUseCase(restaurantId, productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{restaurantId}/product/{productId}/change-status")
    public ResponseEntity<Void> updateProductStatus(@PathVariable Long restaurantId, @PathVariable Long productId, @RequestBody Boolean status){
        this.productUseCase.updateProductStatusUseCase(restaurantId, productId, status);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
