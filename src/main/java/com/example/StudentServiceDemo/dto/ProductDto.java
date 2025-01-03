package com.example.StudentServiceDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String phone;
    private String image;
    private String category;
    private String name;
    private double price;
    private String location;
    private String description;
}
