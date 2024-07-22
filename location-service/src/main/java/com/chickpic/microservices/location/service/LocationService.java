package com.chickpic.microservices.location.service;

import com.chickpic.microservices.location.dto.LocationResponse;
import com.chickpic.microservices.location.model.Location;
import com.chickpic.microservices.location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Location getLocationsByCountry(String country) {
        Optional<Location> location =  locationRepository.findById(country);
        return location.orElse(null);
        //        return locations.stream()
//                        .map(location -> new LocationResponse(location.getId(), location.getCountry(), location.getCity(), location.getLat(), location.getLng(), location.getCountry() + ", " + location.getCity()))
//                        .toList();
    }

//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    private List<Document> generateMongoDocs(List<String> lines) {
//        List<Document> docs = new ArrayList<>();
//        for (String line : lines) {
//            docs.add(Document.parse(line));
//        }
//        return docs;
//    }
//
////    private void insertMongoDocs(String collection, List<Document> docs) {
//    private void insertMongoDocs(String collection, List<String> json) {
//        try {
//            List<Document> docs = generateMongoDocs(json);
//            mongoTemplate.insert(docs, collection);
//        } catch (DataIntegrityViolationException e) {
//            System.out.println(e.getMessage());
//        }
//    }


}
