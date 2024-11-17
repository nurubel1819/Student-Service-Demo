package com.example.StudentServiceDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private int cls;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    private String description;
}
