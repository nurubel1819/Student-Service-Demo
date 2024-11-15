package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.dto.RentDto;
import com.example.StudentServiceDemo.service.RentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/rent")
public class RentController {
    RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @Value("${project.image}")
    private String path;

    // upload rent details with image
    @PostMapping("/upload_details_with_image")
    public ResponseEntity<FileResponseDto> fileUpload(
            @RequestParam("image") MultipartFile image,

            @RequestParam("phone") String phone,
            @RequestParam("location") String location,
            @RequestParam("price") double price,
            @RequestParam("floor") int floor,
            @RequestParam("member") int member,
            @RequestParam("description") String description

    )
    {
        // bind info
        RentDto rentDto = new RentDto();
        rentDto.setPhone(phone);
        rentDto.setLocation(location);
        rentDto.setPrice(price);
        rentDto.setFloor(floor);
        rentDto.setMember(member);
        rentDto.setDescription(description);

        return new ResponseEntity<>(rentService.upload_rent_details(path,image,rentDto), HttpStatus.CREATED);
    }
}