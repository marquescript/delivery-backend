package com.delivery.api.infra.persistence.jpa_entity;

import com.delivery.api.domain.entity.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryProductPersistence categoryProductPersistence;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantPersistence restaurantPersistence;

    public ProductPersistence(Long id, String name, String description, Double price, Boolean active, CategoryProductPersistence categoryProductPersistence, RestaurantPersistence restaurantPersistence) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.categoryProductPersistence = categoryProductPersistence;
        this.restaurantPersistence = restaurantPersistence;
    }

    public static ProductPersistence convertProductToProductPersistence(Product product) {
        return new ProductPersistence(
                product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getActive(),
                CategoryProductPersistence.convertCategoryProductToCategoryProductPersistence(product.getCategoryProduct()),
                RestaurantPersistence.convertRestaurantToRestaurantPersistence(product.getRestaurant())
        );
    }

    public static Product convertProductPersistenceToProduct(ProductPersistence productPersistence) {
        return new Product(
                productPersistence.getId(), productPersistence.getName(), productPersistence.getDescription(), productPersistence.getPrice(),
                productPersistence.getActive(), CategoryProductPersistence.convertCategoryProductPersistenceToCategoryProduct(productPersistence.getCategoryProductPersistence()),
                RestaurantPersistence.convertRestaurantPersistenceToRestaurant(productPersistence.getRestaurantPersistence())
        );
    }

    public ProductPersistence() {}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public CategoryProductPersistence getCategoryProductPersistence() {
        return categoryProductPersistence;
    }

    public void setCategoryProductPersistence(CategoryProductPersistence categoryProductPersistence) {
        this.categoryProductPersistence = categoryProductPersistence;
    }

    public RestaurantPersistence getRestaurantPersistence() {
        return restaurantPersistence;
    }

    public void setRestaurantPersistence(RestaurantPersistence restaurantPersistence) {
        this.restaurantPersistence = restaurantPersistence;
    }
}
