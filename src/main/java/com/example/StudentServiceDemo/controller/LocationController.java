package com.example.StudentServiceDemo.controller;

import com.example.StudentServiceDemo.dto.LocationDto;
import com.example.StudentServiceDemo.dto.SingleResponseDto;
import com.example.StudentServiceDemo.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/upload_new_location")
    private ResponseEntity<SingleResponseDto> upload_new_location(@RequestBody LocationDto locationDto)
    {
        return new ResponseEntity<>(locationService.upload_new_location(locationDto), HttpStatus.CREATED);
    }

    @GetMapping("/get_all_location")
    private ResponseEntity<List<LocationDto>> get_all_location()
    {
        return ResponseEntity.ok(locationService.get_all_location());
    }
}
