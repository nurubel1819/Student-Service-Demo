package com.example.StudentServiceDemo.mapper;

import com.example.StudentServiceDemo.dto.ProductDto;
import com.example.StudentServiceDemo.entity.ProductEntity;

public class ProductMapper {
    public static ProductEntity MapToEntity(ProductDto productDto)
    {
        return new ProductEntity(productDto.getId(),productDto.getImage(),productDto.getCategory(),productDto.getName(),productDto.getPrice(),
                productDto.getLocation(),productDto.getDescription());
    }

    public static ProductDto MapToDto(ProductEntity productEntity)
    {
        return new ProductDto(productEntity.getId(),productEntity.getImage(),productEntity.getCategory(),productEntity.getName(),
                productEntity.getPrice(),productEntity.getLocation(),productEntity.getDescription());
    }
}
