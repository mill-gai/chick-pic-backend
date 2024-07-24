package com.chickpic.microservices.image.controller;

import com.chickpic.microservices.image.dto.ImageByPageResponse;
import com.chickpic.microservices.image.dto.ImageRequest;
import com.chickpic.microservices.image.dto.ImageResponse;
import com.chickpic.microservices.image.model.Image;
import com.chickpic.microservices.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadImage(@RequestPart ImageRequest imageRequest, @RequestPart MultipartFile file) {
//    public String uploadImage(@RequestParam(value = "file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
//            imageService.uploadImage(imageRequest, bytes, filename);
            return imageService.uploadImage(imageRequest, bytes, filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllImages")
    @ResponseStatus(HttpStatus.OK)
    public List<ImageResponse> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/getImageUrls")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getImageUrls(@RequestParam List<String> fileNames) {
        return fileNames.stream().map(imageService::createPresignedUrl).toList();
    }

    @GetMapping("/getImageByPage")
    @ResponseStatus(HttpStatus.OK)
    public ImageByPageResponse getImageByPage(@RequestParam(defaultValue = "") String city, @RequestParam int page, @RequestParam int size) {
        return imageService.getImageByPage(city, page, size);
    }

}
