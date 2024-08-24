package dzholdoshbaev.jobsearch.service;

import org.springframework.web.multipart.MultipartFile;

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
