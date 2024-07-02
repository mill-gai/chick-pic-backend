package com.chickpic.microservices.image.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "image")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Image {
    @Id
    private String id;
    private String title;
    private String description;
    private String country;
    private String city;
    private String fileName;
}
