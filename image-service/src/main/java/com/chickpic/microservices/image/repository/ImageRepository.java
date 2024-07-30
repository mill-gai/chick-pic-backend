package com.chickpic.microservices.image.repository;

import com.chickpic.microservices.image.model.Image;
import com.chickpic.microservices.image.model.LocationsOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ImageRepository extends JpaRepository<Image, Long> {
    Page<Image> findAllByCountryAndCity(String country, String city, Pageable pageable);
    @Query("SELECT DISTINCT i.country AS country, i.city AS city, i.lat AS lat, i.lng AS lng FROM Image i")
    List<LocationsOnly> findDistinctByCountryAndCity();
//    List<Image> findAllByCountry(String country);
}
