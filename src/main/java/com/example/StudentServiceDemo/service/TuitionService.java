package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.TuitionDto;

import java.util.List;

public interface TuitionService {
    public SingleResponseDto upload_new_student(TuitionDto tuitionDto);
    public SingleResponseDto upload_new_teacher(TuitionDto tuitionDto);
    public List<TuitionDto> get_all_tuition();
    public TuitionDto get_singe_tuition_details(Long id);
}
