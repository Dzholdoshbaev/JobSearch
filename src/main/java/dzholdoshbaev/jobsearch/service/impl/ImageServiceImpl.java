package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Slf4j
@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public String upload(MultipartFile file) {
        var response = ImageService.uploadImage(file);
        log.info("Image uploaded successfully");
        return response;
    }

    @Override
    public ResponseEntity<?> download(String name) {
        var response = ImageService.downloadImage(name , MediaType.IMAGE_JPEG);
        log.info("Image downloaded successfully");
        return ResponseEntity.ok(response);
    }

}
