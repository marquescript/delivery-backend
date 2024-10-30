package com.delivery.api.application.use_cases.product;

import com.delivery.api.application.service.ProductService;
import com.delivery.api.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindProductByRestaurant {

    private final ProductService productService;

    @Autowired
    public FindProductByRestaurant(
            ProductService productService
    ){
            this.productService = productService;
    }

    public Product execute(Long restaurantId, Long productId){
        return this.productService.findProductByRestaurant(restaurantId, productId);
    }

}
