package com.example.StudentServiceDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TuitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String institute;
    private String version;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;
    private String faculty;
    private String grp;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String gender;
    private int cls;
    @Column(nullable = false)
    private double fee;
    private String description;
}
