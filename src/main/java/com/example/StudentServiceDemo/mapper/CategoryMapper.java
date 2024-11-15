package com.example.StudentServiceDemo.mapper;

import com.example.StudentServiceDemo.dto.CategoryDto;
import com.example.StudentServiceDemo.entity.CategoryEntity;

public class CategoryMapper {
    public static CategoryEntity MapToEntity(CategoryDto categoryDto)
    {
        return new CategoryEntity(categoryDto.getId(), categoryDto.getCategory());
    }
    public static CategoryDto MapToDto(CategoryEntity categoryEntity)
    {
        return new CategoryDto(categoryEntity.getId(), categoryEntity.getCategory());
    }
}
