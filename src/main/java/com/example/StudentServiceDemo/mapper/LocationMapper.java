package com.example.StudentServiceDemo.mapper;

import com.example.StudentServiceDemo.dto.LocationDto;
import com.example.StudentServiceDemo.entity.LocationEntity;

public class LocationMapper {
    public static LocationEntity MapToEntity(LocationDto locationDto)
    {
        return new LocationEntity(locationDto.getId(),locationDto.getLocation());
    }
    public static LocationDto MapToDto(LocationEntity locationEntity)
    {
        return new LocationDto(locationEntity.getId(), locationEntity.getLocation());
    }
}
