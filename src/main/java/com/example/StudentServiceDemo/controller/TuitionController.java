package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.SingleUploadLongDto;
import com.example.StudentServiceDemo.dto.TuitionDto;
import com.example.StudentServiceDemo.service.TuitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuition")
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

    @PostMapping("/upload_new_teacher")
    private ResponseEntity<SingleResponseDto> upload_new_teacher(@RequestBody TuitionDto tuitionDto)
    {
        return new ResponseEntity<>(tuitionService.upload_new_teacher(tuitionDto),HttpStatus.CREATED);
    }

    @GetMapping("/get_all_tuition")
    private ResponseEntity<List<TuitionDto>> get_all_tuition()
    {
        return ResponseEntity.ok(tuitionService.get_all_tuition());
    }

    @PostMapping("/find_by_id")
    private ResponseEntity<TuitionDto> find_by_post_id(@RequestBody SingleUploadLongDto singleUploadLongDto)
    {
        return ResponseEntity.ok(tuitionService.get_singe_tuition_details(singleUploadLongDto.getId()));
    }

    @PostMapping("/filter_all")
    private ResponseEntity<List<TuitionDto>> filter_all(@RequestBody TuitionDto tuitionDto)
    {
        return ResponseEntity.ok(tuitionService.filter_all(tuitionDto));
    }
}
