package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.dto.ProductDto;
import com.example.StudentServiceDemo.entity.ProductEntity;
import com.example.StudentServiceDemo.mapper.ProductMapper;
import com.example.StudentServiceDemo.repo.ProductRepo;
import com.example.StudentServiceDemo.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
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

    @Override
    public FileResponseDto upload_product(String path, MultipartFile file, ProductDto productDto) {
        //File name
        String originalName = file.getOriginalFilename();
        //Random name generate file
        String randomID = UUID.randomUUID().toString();
        String fileName = randomID.concat(originalName.substring(originalName.lastIndexOf(".")));
        //Full path
        String filePath = path+ File.separator+fileName;
        //Create folder if not created
        File f = new File(path);
        if(!f.exists())
        {
            f.mkdir();
        }
        //File copy
        try {
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //save data
        productDto.setImage(fileName);
        ProductEntity product = ProductMapper.MapToEntity(productDto);
        ProductEntity save_product = productRepo.save(product);
        if(save_product==null) return new FileResponseDto("invalid","not upload");
        else return new FileResponseDto(fileName,"Successfully upload");

    }

}
