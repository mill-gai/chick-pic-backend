package com.chickpic.microservices.image.model;

// projection: https://docs.spring.io/spring-data/jpa/reference/repositories/projections.html
public interface LocationsOnly {
    String getCountry();
    String getCity();
    double getLat();
    double getLng();
}
