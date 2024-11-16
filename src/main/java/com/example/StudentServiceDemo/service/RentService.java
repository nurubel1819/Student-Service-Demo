package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.dto.RentDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RentService {
    public FileResponseDto upload_rent_details(String path, MultipartFile file, RentDto rentDto);
    public List<RentDto> get_all_rent_details();
}
