package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.TushonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TushonRepo extends JpaRepository<TushonEntity,Long> {
}
