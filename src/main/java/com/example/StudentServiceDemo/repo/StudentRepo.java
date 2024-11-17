package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.ProductEntity;
import com.example.StudentServiceDemo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<StudentEntity,Long> {
    StudentEntity findByPhone(String phone);
    List<StudentEntity> findByCls(int cls);
    List<StudentEntity> findByLocationAndCls(String location,int cls);
    List<StudentEntity> findByLocation(String location);
}