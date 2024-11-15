package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.CategoryDto;
import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_category")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/upload_new_category")
    private ResponseEntity<SingleResponseDto> upload_new_category(@RequestBody CategoryDto categoryDto)
    {
        return new ResponseEntity<>(categoryService.upload_new_category(categoryDto), HttpStatus.CREATED);
    }

    @GetMapping("/see_all_category")
    private ResponseEntity<List<CategoryDto>> see_all_category()
    {
        return ResponseEntity.ok(categoryService.get_all_category());
    }
}
