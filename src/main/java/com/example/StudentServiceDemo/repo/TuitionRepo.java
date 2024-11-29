package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.TuitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TuitionRepo extends JpaRepository<TuitionEntity,Long> {
    List<TuitionEntity> findByLocationAndFeeLessThanAndCategoryAndGender(String location,double fee,String category,String gender);
    List<TuitionEntity> findByCategoryAndGender(String category,String gender);
    List<TuitionEntity> findByLocationAndCategoryAndGender(String location,String category,String gender);
    List<TuitionEntity> findByFeeLessThanAndCategoryAndGender(double fee,String category,String gender);
}
