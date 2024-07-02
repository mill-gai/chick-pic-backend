package com.chickpic.microservices.image.dto;

public record ImageResponse(String title, String description, String country, String city, String fileName) {
}
