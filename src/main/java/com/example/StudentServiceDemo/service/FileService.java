package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileService {
    FileResponseDto upload_image(String path, MultipartFile file);
    InputStream getResource(String path,String fileName);
}
