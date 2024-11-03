package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileResponseDto upload_image(String path, MultipartFile file);
}
