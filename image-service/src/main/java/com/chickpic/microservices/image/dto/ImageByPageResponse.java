package com.chickpic.microservices.image.dto;

import java.util.List;

public record ImageByPageResponse(List<ImageResponse> images, boolean isLast ) {
}
