package com.chickpic.microservices.location.config;

import com.chickpic.microservices.location.model.Location;
import com.chickpic.microservices.location.repository.LocationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class LocationLoader implements CommandLineRunner {

    private final LocationRepository locationRepository;

    @Override
    public void run(String... args) throws Exception {
        if(locationRepository.count() <= 0) {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Location>> typeReference = new TypeReference<>(){};
            InputStream inputStream = new ClassPathResource("locationData.json").getInputStream();
            List<Location> locations = mapper.readValue(inputStream, typeReference);
            locationRepository.saveAll(locations);
        }
    }
}
