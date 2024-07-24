package com.chickpic.microservices.image.repository;

import com.chickpic.microservices.image.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<Image, Long> {
    Page<Image> findAllByCity(String city, Pageable pageable);
//    List<Image> findAllByCountry(String country);
}
