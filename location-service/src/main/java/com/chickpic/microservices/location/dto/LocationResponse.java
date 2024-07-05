package com.chickpic.microservices.location.dto;

public record LocationResponse(String id, String country, String city, double lat, double lng, String value) {
}
