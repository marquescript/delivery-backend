package com.delivery.api.application.use_cases.product;

import com.delivery.api.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductStatus {

    private final ProductService productService;

    @Autowired
    public UpdateProductStatus(
            ProductService productService
    ){
        this.productService = productService;
    }

    public void execute(Long restaurantId, Long productId, Boolean status){
        this.productService.updateProductStatus(restaurantId, productId, status);
    }

}
