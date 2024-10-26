package com.delivery.api.domain.entity;

public class CategoryProduct {

    private Long id;
    private String name;

    public CategoryProduct(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryProduct() {}

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
