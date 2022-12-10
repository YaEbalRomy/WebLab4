package com.examle.web4.controller;

import com.examle.web4.dto.ResponseDTO;
import com.examle.web4.dto.UserDTO;
import com.examle.web4.service.RegistrationService;
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
        ResponseDTO responseDTO = registrationService.registration(userDTO.getUsername(),userDTO.getPassword());
        return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(responseDTO.getStatusCode()));
    }
}
