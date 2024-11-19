package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.dto.ProductDto;
import com.example.StudentServiceDemo.entity.ProductEntity;
import com.example.StudentServiceDemo.entity.RentEntity;
import com.example.StudentServiceDemo.mapper.ProductMapper;
import com.example.StudentServiceDemo.mapper.RentMapper;
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
    public List<ProductDto> filter_search_using_name(ProductDto productDto) {
        String name = productDto.getName();
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

    @Override
    public ProductDto get_single_product_details(Long id) {
        ProductEntity single_product_details = productRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("rent post id not found !"));
        return ProductMapper.MapToDto(single_product_details);
    }

    @Override
    public List<ProductDto> find_by_category_and_price(ProductDto productDto) {

        String category = productDto.getCategory();
        double price = productDto.getPrice();
        //String location = productDto.getLocation();

        if(!category.equals("All") && price!=-1)
        {
            List<ProductEntity> all_product = productRepo.findByCategoryAndPriceLessThan(category,price);
            return all_product.stream().map(ProductMapper::MapToDto).collect(Collectors.toList());
        }
        else if(category.equals("All") && price==-1)
        {
            List<ProductEntity> all_product = productRepo.findAll();
            return all_product.stream().map(ProductMapper::MapToDto).collect(Collectors.toList());
        }
        else if(!category.equals("All"))
        {
            List<ProductEntity> all_product = productRepo.findByCategory(category);
            return all_product.stream().map(ProductMapper::MapToDto).collect(Collectors.toList());
        }
        else
        {
            List<ProductEntity> all_product = productRepo.findByPriceLessThan(price);
            return all_product.stream().map(ProductMapper::MapToDto).collect(Collectors.toList());
        }
    }
}
