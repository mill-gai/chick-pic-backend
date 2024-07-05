package com.chickpic.microservices.location.repository;

import com.chickpic.microservices.location.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}
