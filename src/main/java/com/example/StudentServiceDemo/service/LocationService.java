package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.LocationDto;
import com.example.StudentServiceDemo.dto.SingleResponseDto;

import java.util.List;

public interface LocationService {
    public SingleResponseDto upload_new_location(LocationDto locationDto);
    public List<LocationDto> get_all_location();
}
