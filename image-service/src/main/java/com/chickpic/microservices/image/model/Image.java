package com.chickpic.microservices.image.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String country;
    private String city;
    private double lat;
    private double lng;
    private String fileName;
}
