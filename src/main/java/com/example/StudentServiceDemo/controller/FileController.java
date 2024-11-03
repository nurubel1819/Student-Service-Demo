package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponseDto> fileUpload(
            @RequestParam("image") MultipartFile image
    )
    {
        //String fileName = this.fileService.upload_image(path,image);
        return new ResponseEntity<>(fileService.upload_image(path,image), HttpStatus.OK);
    }
}
