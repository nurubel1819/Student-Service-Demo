package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<LocationEntity,Long> {
}
