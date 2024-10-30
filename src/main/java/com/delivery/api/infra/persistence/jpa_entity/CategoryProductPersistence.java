package com.delivery.api.infra.persistence.jpa_entity;

import com.delivery.api.domain.entity.CategoryProduct;
import jakarta.persistence.*;

@Entity
@Table(name = "category_product")
public class CategoryProductPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CategoryProductPersistence(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryProductPersistence() {}

    public static CategoryProductPersistence convertCategoryProductToCategoryProductPersistence(CategoryProduct categoryProduct) {
        return new CategoryProductPersistence(categoryProduct.getId(), categoryProduct.getName());
    }

    public static CategoryProduct convertCategoryProductPersistenceToCategoryProduct(CategoryProductPersistence categoryProductPersistence) {
        return new CategoryProduct(categoryProductPersistence.getId(), categoryProductPersistence.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
