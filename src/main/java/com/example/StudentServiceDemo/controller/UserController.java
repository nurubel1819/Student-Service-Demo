package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.LoginUserDto;
import com.example.StudentServiceDemo.dto.UserDto;
import com.example.StudentServiceDemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    private ResponseEntity<UserDto> registration_new_user(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.registration_new_user(userDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    private ResponseEntity<String> login_user(@RequestBody LoginUserDto loginUserDto)
    {
        return ResponseEntity.ok(userService.login_user(loginUserDto));
    }

    @GetMapping("/see_all_user")
    private ResponseEntity<List<UserDto>> see_all_user()
    {
        return ResponseEntity.ok(userService.see_all_user());
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> delete_user(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.delete_user(id));
    }
}
