package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.TushonDto;
import com.example.StudentServiceDemo.entity.ProductEntity;
import com.example.StudentServiceDemo.entity.TushonEntity;
import com.example.StudentServiceDemo.mapper.ProductMapper;
import com.example.StudentServiceDemo.mapper.TushoneMapper;
import com.example.StudentServiceDemo.repo.TushonRepo;
import com.example.StudentServiceDemo.service.TushonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TushonServiceImpl implements TushonService {

    TushonRepo tushonRepo;

    public TushonServiceImpl(TushonRepo tushonRepo) {
        this.tushonRepo = tushonRepo;
    }

    @Override
    public SingleResponseDto upload_new_student(TushonDto tushonDto) {

        TushonEntity student = TushoneMapper.MapToEntity(tushonDto);
        TushonEntity save_student = tushonRepo.save(student);
        if(save_student==null) return new SingleResponseDto("Upload Failed");
        else return new SingleResponseDto("Upload Successful");
    }

    @Override
    public SingleResponseDto upload_new_teacher(TushonDto tushonDto) {
        TushonEntity teacher = TushoneMapper.MapToEntity(tushonDto);
        TushonEntity save_teacher = tushonRepo.save(teacher);
        if(save_teacher==null) return new SingleResponseDto("Upload Failed");
        else return new SingleResponseDto("Upload Successful");
    }

    @Override
    public List<TushonDto> get_all_tushon() {
        List<TushonEntity> all = tushonRepo.findAll();
        return all.stream().map(TushoneMapper::MapToDto).collect(Collectors.toList());
    }
}
