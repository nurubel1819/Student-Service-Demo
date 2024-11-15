package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.CategoryDto;
import com.example.StudentServiceDemo.dto.SingleResponseDto;

import java.util.List;

public interface CategoryService {
    public SingleResponseDto upload_new_category(CategoryDto categoryDto);
    public List<CategoryDto> get_all_category();
}
