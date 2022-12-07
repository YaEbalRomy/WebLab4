package com.examle.web4.controllers;

import com.examle.web4.dto.UserDTO;
import com.examle.web4.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<?> processRegistration(@RequestBody UserDTO userDTO) {
        log.info("Принят запрос на регистрацию");
        try {
            return registrationService.registration(userDTO.getUsername(),userDTO.getPassword());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }
}
