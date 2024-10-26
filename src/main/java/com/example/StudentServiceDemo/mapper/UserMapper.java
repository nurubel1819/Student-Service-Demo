package com.example.StudentServiceDemo.mapper;

import com.example.StudentServiceDemo.dto.UserDto;
import com.example.StudentServiceDemo.entity.UserEntity;

public class UserMapper {
    public static UserEntity MapToEntity(UserDto userDto)
    {
        return new UserEntity(userDto.getId(),userDto.getName(),userDto.getPhone(),userDto.getPassword());
    }
    public static UserDto MapToDto(UserEntity userEntity)
    {
        return new UserDto(userEntity.getId(),userEntity.getName(),userEntity.getPhone(),userEntity.getPassword());
    }
}
