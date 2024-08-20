package dzholdoshbaev.jobsearch.controller;

import dzholdoshbaev.jobsearch.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public String uploadAvatar(@RequestParam("file") MultipartFile file , Principal principal) {
        String username = principal.getName();
        imageService.uploadImage(file,username);
        return "redirect:/profile";
    }


//    @GetMapping("byName")
//    public ResponseEntity<?>download(@RequestParam( name = "name") String name) {
//        return ImageService.downloadImage(name, MediaType.IMAGE_JPEG);
//    }
}
