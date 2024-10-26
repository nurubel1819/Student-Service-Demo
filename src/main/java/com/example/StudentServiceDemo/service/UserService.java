package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.LoginUserDto;
import com.example.StudentServiceDemo.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto registration_new_user(UserDto userDto);
    public String login_user(LoginUserDto loginUserDto);
    public List<UserDto> see_all_user();
    public String delete_user(Long id);
}
