package com.example.StudentServiceDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String phone;
    private int cls;
    private String location;
    private String gender;
    private String department;
    private String description;
}
