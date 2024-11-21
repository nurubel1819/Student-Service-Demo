package com.example.StudentServiceDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TushonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String institute;
    @Column(nullable = false)
    private String version;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String phone;
    private String department;
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
