package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.LoginUserDto;
import com.example.StudentServiceDemo.dto.UserDto;
import com.example.StudentServiceDemo.entity.UserEntity;
import com.example.StudentServiceDemo.mapper.UserMapper;
import com.example.StudentServiceDemo.repo.UserRepo;
import com.example.StudentServiceDemo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto registration_new_user(UserDto userDto) {
        UserEntity user = UserMapper.MapToEntity(userDto);
        UserEntity save_user = userRepo.save(user);
        return UserMapper.MapToDto(save_user);
    }

    @Override
    public String login_user(LoginUserDto loginUserDto) {
        String phone = loginUserDto.getPhone();
        String password = loginUserDto.getPassword();
        UserEntity user = userRepo.findByPhone(phone);
        if(user==null) return "This user is not found in server";
        else {
            if(password.equals(user.getPassword())) return "Login successfully";
            else return "Password not valid";
        }
    }

    @Override
    public LoginUserDto user_login_confirmation(LoginUserDto loginUserDto) {
        String phone = loginUserDto.getPhone();
        String password = loginUserDto.getPassword();
        UserEntity user = userRepo.findByPhone(phone);
        if(user==null)
        {
            loginUserDto.setPhone("not found");
            loginUserDto.setPassword("invalid");
            return loginUserDto;
        }
        else {
            if(password.equals(user.getPassword()))
            {
                loginUserDto.setPassword("valid");
                return loginUserDto;
            }
            else
            {
                loginUserDto.setPassword("invalid");
                return loginUserDto;
            }
        }
    }

    @Override
    public List<UserDto> see_all_user() {
        List<UserEntity> all_user = userRepo.findAll();
        //convert entity to dto
        return all_user.stream().map(UserMapper::MapToDto).collect(Collectors.toList());
    }

    @Override
    public String delete_user(Long id) {
        userRepo.deleteById(id);
        return "Delete successfully";
    }

    @Override
    public UserDto get_user_by_phone(UserDto userDto) {
        String phone_number = userDto.getPhone();
        UserEntity user = userRepo.findByPhone(phone_number);
        return UserMapper.MapToDto(user);
    }
}
