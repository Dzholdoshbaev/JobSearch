package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.service.ImageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public String upload(MultipartFile file) {
        return ImageService.uploadImage(file);
    }

    @Override
    public ResponseEntity<?> download(String name) {
        return ImageService.downloadImage(name , MediaType.IMAGE_JPEG);
    }

}
