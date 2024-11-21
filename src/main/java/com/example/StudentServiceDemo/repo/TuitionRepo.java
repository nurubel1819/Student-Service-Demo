package com.example.StudentServiceDemo.repo;

import com.example.StudentServiceDemo.entity.TuitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuitionRepo extends JpaRepository<TuitionEntity,Long> {
}
