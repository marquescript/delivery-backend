package com.delivery.api.application.use_cases.product;

import com.delivery.api.application.service.ProductService;
import com.delivery.api.application.service.RestaurantService;
import com.delivery.api.domain.entity.Product;
import com.delivery.api.infra.http.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProduct {

    private final ProductService productService;
    private final RestaurantService restaurantService;

    @Autowired
    public CreateProduct(
            ProductService productService,
            RestaurantService restaurantService
    ){
        this.productService = productService;
        this.restaurantService = restaurantService;
    }

    public Product execute(ProductRequest productRequest){
        Product product = ProductRequest.convertDtoToEntity(productRequest);

        //veificar se a categoria existe
        this.restaurantService.findRestaurant(product.getRestaurant().getId());
        return this.productService.createProduct(product);
    }

}
