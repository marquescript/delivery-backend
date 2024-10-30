package com.delivery.api.application.use_cases.product;

import com.delivery.api.application.service.ProductService;
import com.delivery.api.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductsByRestaurantAndName {

    private final ProductService productService;

    @Autowired
    public FindProductsByRestaurantAndName(
            ProductService productService
    ){
        this.productService = productService;
    }

    public List<Product> execute(Long restaurantId, String name, int page , int size){
        return this.productService.findProductsByRestaurantAndName(restaurantId, name, page , size);
    }

}
