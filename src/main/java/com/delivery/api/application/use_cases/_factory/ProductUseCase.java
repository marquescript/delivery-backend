package com.delivery.api.application.use_cases._factory;

import com.delivery.api.application.use_cases.product.*;
import com.delivery.api.domain.entity.Product;
import com.delivery.api.infra.http.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductUseCase {

    private final CreateProduct createProduct;
    private final DeleteProduct deleteProduct;
    private final FindProductByRestaurant findProductByRestaurant;
    private final FindProductsByRestaurant findProductsByRestaurant;
    private final FindProductsByRestaurantAndName findProductsByRestaurantAndName;
    private final FindProductsByRestaurantAndCategory findProductsByRestaurantAndCategory;
    private final UpdateProductStatus updateProductStatus;

    @Autowired
    public ProductUseCase(
            CreateProduct createProduct,
            DeleteProduct deleteProduct,
            FindProductByRestaurant findProductByRestaurant,
            FindProductsByRestaurant findProductsByRestaurant,
            FindProductsByRestaurantAndName findProductsByRestaurantAndName,
            FindProductsByRestaurantAndCategory findProductsByRestaurantAndCategory,
            UpdateProductStatus updateProductStatus
    ){
            this.createProduct = createProduct;
            this.deleteProduct = deleteProduct;
            this.findProductByRestaurant = findProductByRestaurant;
            this.findProductsByRestaurant = findProductsByRestaurant;
            this.findProductsByRestaurantAndName = findProductsByRestaurantAndName;
            this.findProductsByRestaurantAndCategory = findProductsByRestaurantAndCategory;
            this.updateProductStatus = updateProductStatus;
    }

    public Product createProductUseCase(ProductRequest productRequest){
        return this.createProduct.execute(productRequest);
    }

    public void deleteProductUseCase(Long restaurantId, Long productId){
        this.deleteProduct.execute(restaurantId, productId);
    }

    public Product findProductByRestaurantUseCase(Long restaurantId, Long productId){
        return this.findProductByRestaurant.execute(restaurantId, productId);
    }

    public List<Product> findProductsByRestaurantUseCase(Long restaurantId, int page, int size){
        return this.findProductsByRestaurant.execute(restaurantId, page, size);
    }

    public List<Product> findProductsByRestaurantAndNameUseCase(Long restaurantId, String name, int page, int size){
        return this.findProductsByRestaurantAndName.execute(restaurantId, name, page, size);
    }

    public List<Product> findProductsByRestaurantAndCategoryUseCase(Long restaurantId, Long categoryId, int page, int size){
        return this.findProductsByRestaurantAndCategory.execute(restaurantId, categoryId, page, size);
    }

    public void updateProductStatusUseCase(Long restaurantId, Long productId, Boolean status){
        this.updateProductStatus.execute(restaurantId, productId, status);
    }

}
