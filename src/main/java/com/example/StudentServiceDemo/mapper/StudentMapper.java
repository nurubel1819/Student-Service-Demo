package com.example.StudentServiceDemo.mapper;

import com.example.StudentServiceDemo.dto.StudentDto;
import com.example.StudentServiceDemo.entity.StudentEntity;

public class StudentMapper {
    public static StudentEntity MapToEntity(StudentDto studentDto)
    {
        return new StudentEntity(studentDto.getId(),studentDto.getName(),studentDto.getPhone(),
                studentDto.getCls(),studentDto.getLocation(),studentDto.getGender(),
                studentDto.getDepartment(),studentDto.getDescription());
    }
    public static StudentDto MapToDto(StudentEntity studentEntity)
    {
        return new StudentDto(studentEntity.getId(),studentEntity.getName(),studentEntity.getPhone(),
                studentEntity.getCls(),studentEntity.getLocation(),studentEntity.getGender(),
                studentEntity.getDepartment(),studentEntity.getDescription());
    }
}
