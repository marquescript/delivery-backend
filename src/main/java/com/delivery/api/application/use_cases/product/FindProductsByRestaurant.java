package com.delivery.api.application.use_cases.product;

import com.delivery.api.application.service.ProductService;
import com.delivery.api.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductsByRestaurant {

    private final ProductService productService;

    @Autowired
    public FindProductsByRestaurant(
            ProductService productService
    ){
        this.productService = productService;
    }

    public List<Product> execute(Long restaurantId, int page , int size){
        return this.productService.findProductsByRestaurant(restaurantId, page , size);
    }

}
