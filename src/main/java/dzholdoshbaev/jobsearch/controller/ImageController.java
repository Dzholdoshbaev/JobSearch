package dzholdoshbaev.jobsearch.controller;

import dzholdoshbaev.jobsearch.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    @PostMapping
    public ResponseEntity<String> uploadAvatar(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(ImageService.uploadImage(file));
    }


    @GetMapping("byName")
    public ResponseEntity<?>download(@RequestParam( name = "name") String name) {
        return ImageService.downloadImage(name, MediaType.IMAGE_JPEG);
    }
}
