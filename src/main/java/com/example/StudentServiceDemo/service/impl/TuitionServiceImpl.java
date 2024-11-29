package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.dto.TuitionDto;
import com.example.StudentServiceDemo.entity.RentEntity;
import com.example.StudentServiceDemo.entity.TuitionEntity;
import com.example.StudentServiceDemo.mapper.RentMapper;
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
    public SingleResponseDto upload_new_teacher(TuitionDto tuitionDto) {
        TuitionEntity teacher = TuitionMapper.MapToEntity(tuitionDto);
        TuitionEntity save_teacher = tuitionRepo.save(teacher);
        if(save_teacher==null) return new SingleResponseDto("Upload Failed");
        else return new SingleResponseDto("Upload Successful");
    }

    @Override
    public List<TuitionDto> get_all_tuition() {
        List<TuitionEntity> all = tuitionRepo.findAll();
        return all.stream().map(TuitionMapper::MapToDto).collect(Collectors.toList());
    }

    @Override
    public TuitionDto get_singe_tuition_details(Long id) {
        TuitionEntity tuitionEntity = tuitionRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Tuition post is not found"));
        return TuitionMapper.MapToDto(tuitionEntity);
    }

    @Override
    public List<TuitionDto> filter_all(TuitionDto tuitionDto) {
        String category = tuitionDto.getCategory();
        String location = tuitionDto.getLocation();
        String gender = tuitionDto.getGender();
        double fee = tuitionDto.getFee();

        if(!location.equals("All") && fee!=-1)
        {
            List<TuitionEntity> all_tuition = tuitionRepo.findByLocationAndFeeLessThanAndCategoryAndGender(location,fee,category,gender);
            return all_tuition.stream().map(TuitionMapper::MapToDto).collect(Collectors.toList());
        }
        else  if(location.equals("All") && fee==-1)
        {
            List<TuitionEntity> all_tuition = tuitionRepo.findByCategoryAndGender(category,gender);
            return all_tuition.stream().map(TuitionMapper::MapToDto).collect(Collectors.toList());
        }
        else if(!location.equals("All"))
        {
            List<TuitionEntity> all_tuition = tuitionRepo.findByLocationAndCategoryAndGender(location,category,gender);
            return all_tuition.stream().map(TuitionMapper::MapToDto).collect(Collectors.toList());
        }
        else
        {
            List<TuitionEntity> all_tuition = tuitionRepo.findByFeeLessThanAndCategoryAndGender(fee+1,category,gender);
            return all_tuition.stream().map(TuitionMapper::MapToDto).collect(Collectors.toList());
        }
    }
}
