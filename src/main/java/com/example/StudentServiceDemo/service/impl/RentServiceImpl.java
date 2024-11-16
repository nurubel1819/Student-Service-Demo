package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.dto.RentDto;
import com.example.StudentServiceDemo.entity.ProductEntity;
import com.example.StudentServiceDemo.entity.RentEntity;
import com.example.StudentServiceDemo.mapper.ProductMapper;
import com.example.StudentServiceDemo.mapper.RentMapper;
import com.example.StudentServiceDemo.repo.RentRepo;
import com.example.StudentServiceDemo.service.RentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RentServiceImpl implements RentService {

    RentRepo rentRepo;

    public RentServiceImpl(RentRepo rentRepo) {
        this.rentRepo = rentRepo;
    }

    @Override
    public FileResponseDto upload_rent_details(String path, MultipartFile file, RentDto rentDto) {
        //File name
        String originalName = file.getOriginalFilename();
        //Random name generate file
        String randomID = UUID.randomUUID().toString();
        String fileName = randomID.concat(originalName.substring(originalName.lastIndexOf(".")));
        //Full path
        String filePath = path+ File.separator+fileName;
        //Create folder if not created
        File f = new File(path);
        if(!f.exists())
        {
            f.mkdir();
        }
        //File copy
        try {
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //save data
        rentDto.setImage(fileName);
        RentEntity rentEntity = RentMapper.MapToEntity(rentDto);
        RentEntity save_rent = rentRepo.save(rentEntity);
        if(save_rent==null) return new FileResponseDto("invalid","not upload");
        else return new FileResponseDto(fileName,"Successfully upload");
    }

    @Override
    public List<RentDto> get_all_rent_details() {
        List<RentEntity> all_rent = rentRepo.findAll();
        return all_rent.stream().map(RentMapper::MapToDto).collect(Collectors.toList());
    }

    @Override
    public RentDto get_single_rent_details(Long id) {
        RentEntity single_rent_details = rentRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("rent post id not found !"));
        return RentMapper.MapToDto(single_rent_details);
    }
}
