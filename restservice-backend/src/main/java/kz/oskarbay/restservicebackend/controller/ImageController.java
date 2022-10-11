package kz.oskarbay.restservicebackend.controller;

import kz.oskarbay.restservicebackend.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/image/upload")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService service;

    @PostMapping("/main")
    public ResponseEntity<?> uploadAvatar(@RequestParam("file") MultipartFile uploadFile) {
        return service.uploadAvatar(uploadFile);
    }
}
