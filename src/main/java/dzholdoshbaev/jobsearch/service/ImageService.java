package dzholdoshbaev.jobsearch.service;

import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public interface ImageService {
    void uploadImage(MultipartFile file, String username);


//    static ResponseEntity<?> downloadImage(String filename, MediaType mediaType) {
//        try {
//            byte[] image = Files.readAllBytes(Paths.get(UPLOAD_DIR + filename));
//            Resource resource = new ByteArrayResource(image);
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
//                    .contentLength(resource.contentLength())
//                    .contentType(mediaType)
//                    .body(resource);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Image not found");
//        }
//    }
}
