package com.example.StudentServiceDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {
    private Long id;
    private String image;
    private String phone;
    private String location;
    private double price;
    private int floor;
    private int member;
    private String description;
}
