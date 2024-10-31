package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.CategoryProduct;
import com.delivery.api.infra.http.handler.validation.GroupsValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryProductRequest(

        @NotNull(groups = GroupsValidation.GetCategoryProductId.class)
        Long id,

        @NotBlank
        String name

) {

    public static CategoryProduct convertDtoToEntity(CategoryProductRequest categoryProductRequest){
        return new CategoryProduct(categoryProductRequest.id(), categoryProductRequest.name());
    }

}
