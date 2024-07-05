package com.chickpic.microservices.location.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="location")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Location {
    @Id
    private String id;
    private String country;
    private String city;
    private double lat;
    private double lng;
}
