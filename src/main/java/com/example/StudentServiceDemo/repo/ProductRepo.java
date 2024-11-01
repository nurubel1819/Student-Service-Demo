package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByName(String name);
    List<ProductEntity> findByLocation(String location);
    List<ProductEntity> findByCategory(String category);
    List<ProductEntity> findByNameLike(String name);
    List<ProductEntity> findByNameStartingWith(String name);
    List<ProductEntity> findByNameContaining(String string);
    List<ProductEntity> findByPriceLessThan(Double price);
    List<ProductEntity> findByCategoryAndLocation(String category,String location);
}
