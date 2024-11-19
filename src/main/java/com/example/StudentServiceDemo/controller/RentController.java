package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.FileResponseDto;
import com.example.StudentServiceDemo.dto.RentDto;
import com.example.StudentServiceDemo.dto.SingleUploadLongDto;
import com.example.StudentServiceDemo.service.RentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    // find all rent details
    @GetMapping("/get_all")
    private ResponseEntity<List<RentDto>> get_all_rent_details()
    {
        return ResponseEntity.ok(rentService.get_all_rent_details());
    }

    @PostMapping("/find_by_id")
    private ResponseEntity<RentDto> find_by_post_id(@RequestBody SingleUploadLongDto singleUploadLongDto)
    {
        Long id = singleUploadLongDto.getId();
        return ResponseEntity.ok(rentService.get_single_rent_details(id));
    }

    @PostMapping("/filter_all")
    private ResponseEntity<List<RentDto>> filter_all(@RequestBody RentDto rentDto)
    {
        return ResponseEntity.ok(rentService.filter_all(rentDto));
    }
}
