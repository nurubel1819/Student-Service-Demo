package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findByName(String name);
    UserEntity findByPhone(String phone);
}
