package com.delivery.api.application.use_cases.product;

import com.delivery.api.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProduct {

    private final ProductService productService;

    @Autowired
    public DeleteProduct(
            ProductService productService
    ){
        this.productService = productService;
    }

    public void execute(Long restaurantId, Long productId){
        this.productService.deleteProduct(restaurantId, productId);
    }

}
