package com.chickpic.microservices.image.dto;

public record ImageRequest(String title, String description, String country, String city, double lat, double lng) {
}
