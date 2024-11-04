package com.example.StudentServiceDemo.service.impl;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public FileResponseDto upload_image(String path, MultipartFile file) {

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

        return new FileResponseDto(fileName,"image is successfully upload");
    }

    @Override
    public InputStream getResource(String path, String fileName) {
        String fullPath = path+File.separator+fileName;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fullPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return inputStream;
    }
}
