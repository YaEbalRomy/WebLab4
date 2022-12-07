package com.examle.web4.controllers;

import com.examle.web4.dto.UserDTO;
import com.examle.web4.services.AuthorizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/authorization")
@RequiredArgsConstructor
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    @PostMapping
    public ResponseEntity<?> authorization(@RequestBody UserDTO userDTO) {
        log.info("Принят запрос на авторизацию");
        return authorizationService.authorization(userDTO.getUsername(), userDTO.getPassword());
    }
}
