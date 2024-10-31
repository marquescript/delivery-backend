package com.delivery.api.application.service;

import com.delivery.api.domain.entity.CategoryProduct;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.repository.CategoryProductRepository;
import com.delivery.api.infra.persistence.jpa_entity.CategoryProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductService {

    private final CategoryProductRepository<CategoryProductPersistence> categoryProductRepository;

    @Autowired
    public CategoryProductService(
            @Qualifier("jpa") CategoryProductRepository<CategoryProductPersistence> categoryProductRepository
    ){
        this.categoryProductRepository = categoryProductRepository;
    }

    public CategoryProduct findCategoryProduct(Long categoryProductId){
        CategoryProductPersistence categoryProductPersistence = this.categoryProductRepository.findById(categoryProductId).orElseThrow(() -> new EntityNotFound("CategoryProduct not found"));
        return CategoryProductPersistence.convertCategoryProductPersistenceToCategoryProduct(categoryProductPersistence);
    }

    public CategoryProduct createCategoryProduct(CategoryProduct categoryProduct){
        CategoryProductPersistence categoryProductPersistence = CategoryProductPersistence.convertCategoryProductToCategoryProductPersistence(categoryProduct);
        categoryProductPersistence = this.categoryProductRepository.save(categoryProductPersistence);
        return CategoryProductPersistence.convertCategoryProductPersistenceToCategoryProduct(categoryProductPersistence);
    }

    public List<CategoryProduct> findAllCategoryProducts(int page, int size){
        List<CategoryProductPersistence> categoryProductPersistences = this.categoryProductRepository.findAll(page, size);
        return categoryProductPersistences.stream().map(CategoryProductPersistence::convertCategoryProductPersistenceToCategoryProduct).toList();
    }

}
