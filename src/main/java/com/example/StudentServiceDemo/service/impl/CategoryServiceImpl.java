package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.CategoryDto;
import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.entity.CategoryEntity;
import com.example.StudentServiceDemo.entity.LocationEntity;
import com.example.StudentServiceDemo.mapper.CategoryMapper;
import com.example.StudentServiceDemo.mapper.LocationMapper;
import com.example.StudentServiceDemo.repo.CategoryRepo;
import com.example.StudentServiceDemo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public SingleResponseDto upload_new_category(CategoryDto categoryDto) {
        CategoryEntity new_category = CategoryMapper.MapToEntity(categoryDto);
        CategoryEntity save_category = categoryRepo.save(new_category);
        if(save_category==null) return new SingleResponseDto("failed to upload");
        else return new SingleResponseDto("Upload Successfully");
    }

    @Override
    public List<CategoryDto> get_all_category() {
        List<CategoryEntity> all_category = categoryRepo.findAll();
        return all_category.stream().map(CategoryMapper::MapToDto).collect(Collectors.toList());
    }
}
