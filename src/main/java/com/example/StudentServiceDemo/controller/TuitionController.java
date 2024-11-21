package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.TuitionDto;
import com.example.StudentServiceDemo.service.TuitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class TuitionController {
    TuitionService tuitionService;

    public TuitionController(TuitionService tuitionService) {
        this.tuitionService = tuitionService;
    }

    @PostMapping("/upload_new_student")
    private ResponseEntity<SingleResponseDto> upload_new_student(@RequestBody TuitionDto tuitionDto)
    {
        return new ResponseEntity<>(tuitionService.upload_new_student(tuitionDto), HttpStatus.CREATED);
    }
}
