package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.CategoryProduct;
import com.delivery.api.domain.entity.Product;

public record ProductRequest(
        Long id,

        String name,

        String description,

        Double price,

        Boolean active,

        CategoryProduct categoryProduct,

        RestaurantRequest restaurant

) {

    public static Product convertDtoToEntity(ProductRequest productRequest){
        return new Product(
                productRequest.id(),
                productRequest.name(),
                productRequest.description(),
                productRequest.price(),
                productRequest.active(),
                productRequest.categoryProduct(),
                RestaurantRequest.convertDtoToEntity(productRequest.restaurant())
        );
    }

}
