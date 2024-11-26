package com.example.StudentServiceDemo.mapper;

import com.example.StudentServiceDemo.dto.TuitionDto;
import com.example.StudentServiceDemo.entity.TuitionEntity;

public class TuitionMapper {
    public static TuitionEntity MapToEntity(TuitionDto dto)
    {
        return new TuitionEntity(dto.getId(), dto.getCategory(),dto.getInstitute(),dto.getVersion(),
                dto.getName(),dto.getPhone(),dto.getFaculty(),dto.getGrp(),dto.getLocation(),
                dto.getGender(),dto.getCls(),dto.getFee(),dto.getDescription());
    }
    public static TuitionDto MapToDto(TuitionEntity entity)
    {
        return new TuitionDto(entity.getId(),entity.getCategory(),entity.getInstitute(),entity.getVersion(),
                entity.getName(),entity.getPhone(),entity.getFaculty(),entity.getGrp(),entity.getLocation(),
                entity.getGender(),entity.getCls(),entity.getFee(),entity.getDescription());
    }
}
