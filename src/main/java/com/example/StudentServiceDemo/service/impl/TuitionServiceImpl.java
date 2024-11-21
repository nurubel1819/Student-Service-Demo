package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.TuitionDto;
import com.example.StudentServiceDemo.entity.TuitionEntity;
import com.example.StudentServiceDemo.mapper.TuitionMapper;
import com.example.StudentServiceDemo.repo.TuitionRepo;
import com.example.StudentServiceDemo.service.TuitionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TuitionServiceImpl implements TuitionService {

    TuitionRepo tuitionRepo;

    public TuitionServiceImpl(TuitionRepo tushonRepo) {
        this.tuitionRepo = tushonRepo;
    }

    @Override
    public SingleResponseDto upload_new_student(TuitionDto tuitionDto) {

        TuitionEntity student = TuitionMapper.MapToEntity(tuitionDto);
        TuitionEntity save_student = tuitionRepo.save(student);
        if(save_student==null) return new SingleResponseDto("Upload Failed");
        else return new SingleResponseDto("Upload Successful");
    }

    @Override
    public SingleResponseDto upload_new_teacher(TuitionDto tushonDto) {
        TuitionEntity teacher = TuitionMapper.MapToEntity(tushonDto);
        TuitionEntity save_teacher = tuitionRepo.save(teacher);
        if(save_teacher==null) return new SingleResponseDto("Upload Failed");
        else return new SingleResponseDto("Upload Successful");
    }

    @Override
    public List<TuitionDto> get_all_tuition() {
        List<TuitionEntity> all = tuitionRepo.findAll();
        return all.stream().map(TuitionMapper::MapToDto).collect(Collectors.toList());
    }
}
