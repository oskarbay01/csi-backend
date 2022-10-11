package kz.oskarbay.restservicebackend.service;

import kz.oskarbay.restservicebackend.domain.entity.AppUser;
import kz.oskarbay.restservicebackend.models.ResponseModel;
import kz.oskarbay.restservicebackend.models.validator.AppUserValidator;
import kz.oskarbay.restservicebackend.repository.AppUserRepository;
import kz.oskarbay.restservicebackend.settings.Strings;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository repo;

    public ResponseEntity<?> getAllUsers() {
        return ResponseModel.success(repo.findAll());
    }

    public ResponseEntity<?> addUser(AppUserValidator appUserValidator) {
        if (appUserValidator == null)
            return ResponseModel.error(HttpStatus.BAD_REQUEST, Strings.USER_EXIST);

        return ResponseModel.successPure();
    }

    public ResponseEntity<?> editUser(AppUserValidator appUserValidator) {
        AppUser appUser = repo.findById(appUserValidator.getId()).orElse(null);

        if (appUser == null)
            return ResponseModel.error(HttpStatus.BAD_REQUEST, Strings.USER_EMPTY);

        appUser.setId(appUserValidator.getId());
        appUser.setFullName(appUser.getFullName());
        appUser.setUrl(appUser.getUrl());
        appUser.setEmail(appUser.getEmail());
        appUser.setOnline(appUser.getOnline());

        repo.save(appUser);

        return ResponseModel.success(appUser);
    }
}
