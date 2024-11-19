package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.dto.ProductDto;
import com.example.StudentServiceDemo.dto.SingleUploadLongDto;
import com.example.StudentServiceDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    @Value("${project.image}")
    private String path;

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

    @PostMapping("/filter_name")
    private ResponseEntity<List<ProductDto>> filter_by_name(@RequestBody ProductDto productDto)
    {
        return ResponseEntity.ok(productService.filter_search_using_name(productDto));
    }

    @GetMapping("filter_price/{price}")
    private ResponseEntity<List<ProductDto>> filter_by_price(@PathVariable double price)
    {
        return ResponseEntity.ok(productService.filter_search_using_price(price));
    }

    // upload product details with image
    @PostMapping("/upload_details_with_image")
    public ResponseEntity<FileResponseDto> fileUpload(
            @RequestParam("image") MultipartFile image,

            @RequestParam("phone") String phone,
            @RequestParam("category") String category,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("location") String location,
            @RequestParam("description") String description

    )
    {
        //here create ProductDto object and init it
        ProductDto product = new ProductDto();
        product.setPhone(phone);
        product.setCategory(category);
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        product.setLocation(location);
        product.setDescription(description);

        return new ResponseEntity<>(productService.upload_product(path,image,product),HttpStatus.CREATED);

        //return new ResponseEntity<>(fileService.upload_image(path,image), HttpStatus.OK);
    }

    @PostMapping("/find_by_id")
    private ResponseEntity<ProductDto> find_by_id(@RequestBody SingleUploadLongDto singleUploadLongDto)
    {
        Long id = singleUploadLongDto.getId();
        return ResponseEntity.ok(productService.get_single_product_details(id));
    }

    @PostMapping("/find_by_category_and_location")
    private ResponseEntity<List<ProductDto>> find_by_category_and_location(@RequestBody ProductDto productDto)
    {
        return ResponseEntity.ok(productService.find_by_category_and_location(productDto));
    }
}
