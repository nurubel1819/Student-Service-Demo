package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.ProductDto;
import com.example.StudentServiceDemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/upload")
    private ResponseEntity<String> upload_product_details(@RequestBody ProductDto productDto)
    {
        return new ResponseEntity<>(productService.upload_product_details(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/see_all_product")
    private ResponseEntity<List<ProductDto>> see_all_product()
    {
        return ResponseEntity.ok(productService.see_all_product());
    }

    @GetMapping("/filter_name/{name}")
    private ResponseEntity<List<ProductDto>> filter_by_name(@PathVariable String name)
    {
        return ResponseEntity.ok(productService.filter_search_using_name(name));
    }

    @GetMapping("filter_price/{price}")
    private ResponseEntity<List<ProductDto>> filter_by_price(@PathVariable double price)
    {
        return ResponseEntity.ok(productService.filter_search_using_price(price));
    }
}
