package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public FileResponseDto upload_image(String path, MultipartFile file) {

        //File name
        String name = file.getOriginalFilename();
        //Random name generate file
        String randomID = UUID.randomUUID().toString();
        String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
        //Full path
        String filePath = path+ File.separator+fileName1;
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

        return new FileResponseDto(name,"image is successfully upload");
    }
}
