package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepo extends JpaRepository<RentEntity,Long> {
    List<RentEntity> findByLocation(String location);
    List<RentEntity> findByMember(int member);
    List<RentEntity> findByFloor(int floor);
    List<RentEntity> findByPriceLessThan(double price);
}
