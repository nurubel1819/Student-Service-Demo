package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponseDto> fileUpload(
            @RequestParam("image") MultipartFile image,

            @RequestParam("category") String category,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("location") String location,
            @RequestParam("description") String description

    )
    {
        //here create ProductDto object and init it
        //String fileName = this.fileService.upload_image(path,image);
        return new ResponseEntity<>(fileService.upload_image(path,image), HttpStatus.OK);
    }

    // Method to serve file
    /*@GetMapping(value = "/images/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {
        InputStream resource = this.fileService.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }*/
    @PostMapping(value = "/images",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            //@PathVariable("imageName") String imageName,
            @RequestBody FileResponseDto fileResponseDto,
            HttpServletResponse response
    ) throws IOException {
        String imageName = fileResponseDto.getFileName();
        InputStream resource = this.fileService.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }

}
