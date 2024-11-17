package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.StudentDto;

import java.util.List;

public interface StudentService {
    public SingleResponseDto upload_new_student(StudentDto studentDto);
    public List<StudentDto> find_all_student();
    public List<StudentDto> find_location_and_class(StudentDto studentDto);
}
