package com.example.StudentServiceDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TushonDto {
    private Long id;
    private String category;
    private String institute;
    private String version;
    private String name;
    private String phone;
    private String department;
    private String grp;
    private String location;
    private String gender;
    private int cls;
    private double fee;
    private String description;
}