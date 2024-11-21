package com.example.StudentServiceDemo.service;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.TushonDto;

import java.util.List;

public interface TushonService {
    public SingleResponseDto upload_new_student(TushonDto tushonDto);
    public SingleResponseDto upload_new_teacher(TushonDto tushonDto);
    public List<TushonDto> get_all_tushon();
}
