package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.ProductDto;
import com.example.StudentServiceDemo.entity.ProductEntity;
import com.example.StudentServiceDemo.mapper.ProductMapper;
import com.example.StudentServiceDemo.repo.ProductRepo;
import com.example.StudentServiceDemo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public String upload_product_details(ProductDto productDto) {
        ProductEntity product = ProductMapper.MapToEntity(productDto);
        ProductEntity save_product = productRepo.save(product);
        if(save_product==null) return "Upload Failed";
        else return "Upload Successful";
    }

    @Override
    public List<ProductDto> see_all_product() {
        List<ProductEntity> all_product = productRepo.findAll();
        return all_product.stream().map(ProductMapper::MapToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> filter_search_using_name(String name) {
        List<ProductEntity> all_product = productRepo.findByNameContaining(name);
        return all_product.stream().map(ProductMapper::MapToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> filter_search_using_price(double price) {
        List<ProductEntity> all_product = productRepo.findByPriceLessThan(price);
        return all_product.stream().map(ProductMapper::MapToDto).collect(Collectors.toList());
    }

}
