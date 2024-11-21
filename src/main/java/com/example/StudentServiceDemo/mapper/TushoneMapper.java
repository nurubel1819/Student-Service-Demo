package com.example.StudentServiceDemo.mapper;

import com.example.StudentServiceDemo.dto.TushonDto;
import com.example.StudentServiceDemo.entity.TushonEntity;

public class TushoneMapper {
    public static TushonEntity MapToEntity(TushonDto dto)
    {
        return new TushonEntity(dto.getId(), dto.getCategory(),dto.getInstitute(),dto.getVersion(),
                dto.getName(),dto.getPhone(),dto.getDepartment(),dto.getGrp(),dto.getLocation(),
                dto.getGender(),dto.getCls(),dto.getFee(),dto.getDescription());
    }
    public static TushonDto MapToDto(TushonEntity entity)
    {
        return new TushonDto(entity.getId(),entity.getCategory(),entity.getInstitute(),entity.getVersion(),
                entity.getName(),entity.getPhone(),entity.getDepartment(),entity.getGrp(),entity.getLocation(),
                entity.getGender(),entity.getCls(),entity.getFee(),entity.getDescription());
    }
}
