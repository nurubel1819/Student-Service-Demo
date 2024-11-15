package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.dto.RentDto;
import org.springframework.web.multipart.MultipartFile;

public interface RentService {
    public FileResponseDto upload_rent_details(String path, MultipartFile file, RentDto rentDto);
}
