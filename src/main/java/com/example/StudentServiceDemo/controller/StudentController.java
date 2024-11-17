package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.StudentDto;
import com.example.StudentServiceDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/upload_new_student")
    private ResponseEntity<SingleResponseDto> upload_new_student(@RequestBody StudentDto studentDto)
    {
        return new ResponseEntity<>(studentService.upload_new_student(studentDto), HttpStatus.CREATED);
    }

    @GetMapping("/get_all_student")
    private ResponseEntity<List<StudentDto>> get_all_student()
    {
        return ResponseEntity.ok(studentService.find_all_student());
    }

    @PostMapping("/get_student_by_location_and_cls")
    private ResponseEntity<List<StudentDto>> get_student_by_location_and_cls(@RequestBody StudentDto studentDto)
    {
        return ResponseEntity.ok(studentService.find_location_and_class(studentDto));
    }
}
