package com.example.StudentServiceDemo.mapper;

import com.example.StudentServiceDemo.dto.RentDto;
import com.example.StudentServiceDemo.entity.RentEntity;

public class RentMapper {
    public static RentEntity MapToEntity(RentDto rentDto)
    {
        return new RentEntity(rentDto.getId(),rentDto.getImage(),rentDto.getPhone(),
                rentDto.getLocation(),rentDto.getPrice(),rentDto.getFloor(),
                rentDto.getMember(),rentDto.getDescription());
    }
    public static RentDto MapToDto(RentEntity rentEntity)
    {
        return new RentDto(rentEntity.getId(),rentEntity.getImage(),rentEntity.getPhone(),
                rentEntity.getLocation(),rentEntity.getPrice(),rentEntity.getFloor(),
                rentEntity.getMember(),rentEntity.getDescription());
    }
}
