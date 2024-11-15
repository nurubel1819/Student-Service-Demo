package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.LocationDto;
import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {
    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("upload_new_location")
    private ResponseEntity<SingleResponseDto> upload_new_location(@RequestBody LocationDto locationDto)
    {
        return new ResponseEntity<>(locationService.upload_new_location(locationDto), HttpStatus.CREATED);
    }
}
