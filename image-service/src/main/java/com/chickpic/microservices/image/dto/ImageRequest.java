package com.chickpic.microservices.image.dto;

import java.io.File;

public record ImageRequest(String title, String description, String country, String city) {
}
