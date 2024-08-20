package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.UsersDao;
import dzholdoshbaev.jobsearch.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
//    @Override
//    public String upload(MultipartFile file) {
//        var response = ImageService.uploadImage(file);
//        log.info("Image uploaded successfully");
//        return response;
//    }

    private  final UsersDao usersDao;
    static Path PATH = Path.of("data/images");

    static String UPLOAD_DIR = "data/images/";

    @SneakyThrows
    public void uploadImage(MultipartFile file, String username) {
        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "_" + file.getOriginalFilename();

        Path pathDir = Paths.get(UPLOAD_DIR);
        Files.createDirectories(pathDir);

        Path filePath = Paths.get(pathDir + "/" + resultFileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        try (OutputStream os = Files.newOutputStream(filePath)) {
            os.write(file.getBytes());
            usersDao.addPhoto(username,UPLOAD_DIR + resultFileName) ;
        }
    }

//    @Override
//    public ResponseEntity<?> download(String name) {
//        var response = ImageService.downloadImage(name , MediaType.IMAGE_JPEG);
//        log.info("Image downloaded successfully");
//        return ResponseEntity.ok(response);
//    }

}
