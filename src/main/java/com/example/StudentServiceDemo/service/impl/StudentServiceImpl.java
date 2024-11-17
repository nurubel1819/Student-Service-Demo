package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.StudentDto;
import com.example.StudentServiceDemo.entity.StudentEntity;
import com.example.StudentServiceDemo.mapper.StudentMapper;
import com.example.StudentServiceDemo.repo.StudentRepo;
import com.example.StudentServiceDemo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public SingleResponseDto upload_new_student(StudentDto studentDto) {
        StudentEntity new_student = StudentMapper.MapToEntity(studentDto);
        StudentEntity save_student = studentRepo.save(new_student);
        if(save_student==null) return new SingleResponseDto("Failed!! to upload,try again");
        else return new SingleResponseDto("Data upload successfully");
    }

    @Override
    public List<StudentDto> find_all_student() {
        List<StudentEntity> all_student =  studentRepo.findAll();
        return all_student.stream().map(StudentMapper::MapToDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> find_location_and_class(StudentDto studentDto) {
        List<StudentEntity> all_student = studentRepo.findByLocationAndCls(studentDto.getLocation(),studentDto.getCls());
        return all_student.stream().map(StudentMapper::MapToDto).collect(Collectors.toList());
    }
}
