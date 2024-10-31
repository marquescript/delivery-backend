package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Product;
import com.delivery.api.infra.http.handler.validation.GroupsValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

public record ProductRequest(

        @NotNull(groups = GroupsValidation.GetProductId.class)
        Long id,

        @NotBlank
        String name,

        @NotBlank
        String description,

        @Min(1)
        Double price,

        Boolean active,

        @Valid
        @ConvertGroup(from = Default.class, to = GroupsValidation.GetCategoryProductId.class)
        CategoryProductRequest category,

        @Valid
        @ConvertGroup(from = Default.class, to = GroupsValidation.GetRestaurantId.class)
        RestaurantRequest restaurant

) {

    public static Product convertDtoToEntity(ProductRequest productRequest){
        return new Product(
                productRequest.id(),
                productRequest.name(),
                productRequest.description(),
                productRequest.price(),
                productRequest.active(),
                CategoryProductRequest.convertDtoToEntity(productRequest.category()),
                RestaurantRequest.convertDtoToEntity(productRequest.restaurant())
        );
    }

}
