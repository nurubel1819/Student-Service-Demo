package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity,Long> {

}
