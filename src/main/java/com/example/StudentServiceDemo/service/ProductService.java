package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public String upload_product_details(ProductDto productDto);
    public List<ProductDto> see_all_product();
}
