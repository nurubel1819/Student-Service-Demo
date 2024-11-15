package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity,Long> {

}
