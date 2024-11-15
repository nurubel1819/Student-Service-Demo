package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.LocationDto;
import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.entity.LocationEntity;
import com.example.StudentServiceDemo.mapper.LocationMapper;
import com.example.StudentServiceDemo.mapper.ProductMapper;
import com.example.StudentServiceDemo.repo.LocationRepo;
import com.example.StudentServiceDemo.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    LocationRepo locationRepo;

    public LocationServiceImpl(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @Override
    public SingleResponseDto upload_new_location(LocationDto locationDto) {
        LocationEntity new_location = LocationMapper.MapToEntity(locationDto);
        LocationEntity save_location = locationRepo.save(new_location);
        if(save_location==null) return new SingleResponseDto("failed to upload");
        else return new SingleResponseDto("Upload Successfully");
    }

    @Override
    public List<LocationDto> get_all_location() {
        List<LocationEntity> all_location = locationRepo.findAll();
        return all_location.stream().map(LocationMapper::MapToDto).collect(Collectors.toList());
    }
}
