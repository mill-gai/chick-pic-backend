package com.chickpic.microservices.image.dto;

import java.util.Date;

public record ImageResponse(String title, String description, String country, String city, double lat, double lng, String fileName, Date submissionDate) {
}
