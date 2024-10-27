package com.delivery.api.infra.persistence.entity;

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
