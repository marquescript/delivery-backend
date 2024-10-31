package com.delivery.api.application.service;

import com.delivery.api.domain.entity.Product;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.repository.ProductRepository;
import com.delivery.api.infra.persistence.jpa_entity.ProductPersistence;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository<ProductPersistence> productRepository;

    @Autowired
    public ProductService(
            @Qualifier("jpa") ProductRepository<ProductPersistence> productRepository
    ){
            this.productRepository = productRepository;
    }


    public List<Product> findProductsByRestaurant(Long restaurantId, int page, int size) {
        List<ProductPersistence> productPersistences = this.productRepository.findProductsByRestaurant(restaurantId, page, size);
        return productPersistences.stream().map(ProductPersistence::convertProductPersistenceToProduct).toList();
    }

    public Product findProductByRestaurant(Long restaurantId, Long productId) {
        ProductPersistence productPersistence = this.productRepository.findProductByRestaurant(restaurantId, productId).orElseThrow(() -> new EntityNotFound("Product not found"));
        return ProductPersistence.convertProductPersistenceToProduct(productPersistence);
    }

    public List<Product> findProductsByRestaurantAndCategory(Long restaurantId, Long categoryId, int page, int size){
        List<ProductPersistence> productPersistences = this.productRepository.findProductsByRestaurantAndCategory(restaurantId, categoryId, page, size);
        return productPersistences.stream().map(ProductPersistence::convertProductPersistenceToProduct).toList();
    }

    public List<Product> findProductsByRestaurantAndName(Long restaurantId, String name, int page, int size){
        List<ProductPersistence> productPersistences = this.productRepository.findProductsByRestaurantAndName(restaurantId, name, page, size);
        return productPersistences.stream().map(ProductPersistence::convertProductPersistenceToProduct).toList();
    }

    @Transactional
    public Product createProduct(Product product) {
        ProductPersistence productPersistence = ProductPersistence.convertProductToProductPersistence(product);
        return ProductPersistence.convertProductPersistenceToProduct(this.productRepository.save(productPersistence));
    }

    @Transactional
    public void deleteProduct(Long restaurantId, Long productId) {
        this.findProductByRestaurant(restaurantId, productId);
        this.productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProductStatus(Long restaurantId, Long productId, Boolean status){
        Product product = this.findProductByRestaurant(restaurantId, productId);
        if(product.getActive() != status){
            product.setActive(status);
        }
        ProductPersistence productPersistence = ProductPersistence.convertProductToProductPersistence(product);
        this.productRepository.save(productPersistence);
    }





}
