package com.chickpic.microservices.location.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Unwrapped;

import java.util.List;

@Document(value="location")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Location {
    @Id
    private String country;
    private List<City> cities;
}
