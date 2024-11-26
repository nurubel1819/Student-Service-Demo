package com.example.StudentServiceDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TuitionDto {
    private Long id;
    private String category;
    private String institute;
    private String version;
    private String name;
    private String phone;
    private String faculty;
    private String grp;
    private String location;
    private String gender;
    private int cls;
    private double fee;
    private String description;
}
