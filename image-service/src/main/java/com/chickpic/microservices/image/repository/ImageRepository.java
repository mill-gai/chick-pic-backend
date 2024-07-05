package com.chickpic.microservices.image.repository;

import com.chickpic.microservices.image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
