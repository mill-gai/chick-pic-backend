package com.chickpic.microservices.location.controller;

import com.chickpic.microservices.location.dto.LocationResponse;
import com.chickpic.microservices.location.model.Location;
import com.chickpic.microservices.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/getCitiesByCountry")
    @ResponseStatus(HttpStatus.OK)
    public Location getCitiesByCountry(@RequestParam String country) { return locationService.getCitiesByCountry(country); }

    @GetMapping("/getAllCountries")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getAllCountries() { return locationService.getAllCountries(); }

}

