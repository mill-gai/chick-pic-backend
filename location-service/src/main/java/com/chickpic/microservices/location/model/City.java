package com.chickpic.microservices.location.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="city")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class City {
    private String city;
    private double lat;
    private double lng;
}
