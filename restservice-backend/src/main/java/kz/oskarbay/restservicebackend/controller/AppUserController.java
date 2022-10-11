package kz.oskarbay.restservicebackend.controller;

import kz.oskarbay.restservicebackend.models.validator.AppUserValidator;
import kz.oskarbay.restservicebackend.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/appUserController")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService service;

    @GetMapping("/all")
    public ResponseEntity<?> allUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody AppUserValidator appUserValidator){
        return service.addUser(appUserValidator);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> editUser(@Valid @RequestBody AppUserValidator appUserValidator) {
        return service.editUser(appUserValidator);
    }




}
