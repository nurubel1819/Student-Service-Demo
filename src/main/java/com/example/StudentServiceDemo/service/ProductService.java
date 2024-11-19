package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public String upload_product_details(ProductDto productDto);
    public List<ProductDto> see_all_product();
    public List<ProductDto> filter_search_using_name(ProductDto productDto);
    public List<ProductDto> filter_search_using_price(double price);
    public FileResponseDto upload_product(String path, MultipartFile file,ProductDto productDto);
    public ProductDto get_single_product_details(Long id);
    public List<ProductDto> find_by_category_and_price(ProductDto productDto);
}
