package com.example.StudentServiceDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int floor;
    @Column(nullable = false)
    private int member;
    @Column(nullable = false)
    private String description;
}
