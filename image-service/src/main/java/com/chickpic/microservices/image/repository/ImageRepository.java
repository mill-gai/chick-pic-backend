package com.chickpic.microservices.image.repository;

import com.chickpic.microservices.image.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
}
