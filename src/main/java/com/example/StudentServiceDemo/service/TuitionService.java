package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.TuitionDto;

import java.util.List;

public interface TuitionService {
    public SingleResponseDto upload_new_student(TuitionDto tushonDto);
    public SingleResponseDto upload_new_teacher(TuitionDto tushonDto);
    public List<TuitionDto> get_all_tuition();
}
