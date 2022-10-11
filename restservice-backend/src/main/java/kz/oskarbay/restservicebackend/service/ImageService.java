package kz.oskarbay.restservicebackend.service;

import kz.oskarbay.restservicebackend.models.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageService {

    public ResponseEntity<?> uploadAvatar(MultipartFile uploadFile) {
        if (uploadFile.isEmpty())
            return ResponseModel.error(HttpStatus.BAD_REQUEST, "Введите файл");

        return ResponseModel.success(uploadFile.getOriginalFilename());
    }
}
