package com.chickpic.microservices.image.service;

import com.chickpic.microservices.image.dto.ImageRequest;
import com.chickpic.microservices.image.dto.ImageResponse;
import com.chickpic.microservices.image.model.Image;
import com.chickpic.microservices.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    @Value("${amazon.s3.bucket-name}")
    private String bucketName;
    private final S3Client s3Client;
    private final S3Presigner s3Presigner;
    private final ImageRepository imageRepository;

    public String uploadImage(ImageRequest imageRequest, byte[] bytes, String fileName) {
        fileName = generateFileName(fileName);
        try {
            PutObjectRequest putObj = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .build();
            Image image = Image.builder()
                    .title(imageRequest.title())
                    .description(imageRequest.description())
                    .country(imageRequest.country())
                    .city(imageRequest.city())
                    .lat(imageRequest.lat())
                    .lng(imageRequest.lng())
                    .fileName(fileName)
                    .build();

            s3Client.putObject(putObj, RequestBody.fromBytes(bytes));
            imageRepository.save(image);
            return "Image uploaded successfully";
        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
//            throw new RuntimeException(e);
            throw new RuntimeException("Failed to upload image", e);
        }
    }

    public List<ImageResponse> getAllImages() {
        List<Image> images = imageRepository.findAll();
//        List<String> urls = images.stream()
//                            .map(image -> generateFileName(image.getFileName()))
//                            .toList();

        return images.stream()
                .map(image -> new ImageResponse(image.getTitle(), image.getDescription(), image.getCountry(), image.getCity(), image.getLat(), image.getLng(), image.getFileName()))
                .toList();
    }

    public String createPresignedUrl(String keyName) {
        try {
            GetObjectRequest getObj = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(keyName)
                    .build();
            GetObjectPresignRequest presignReq = GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(5))
                    .getObjectRequest(getObj)
                    .build();
            PresignedGetObjectRequest presignedReq = s3Presigner.presignGetObject(presignReq);
            System.out.println("url to string: " + presignedReq.url().toString());
            System.out.println("url to external form: " + presignedReq.url().toExternalForm());

            return presignedReq.url().toString();
        } catch (S3Exception e) {
            throw new RuntimeException("Failed to get presigned url", e);
        }

    }

    private String generateFileName(String fileName) {
        return new Date().getTime() + fileName;
    }
}
