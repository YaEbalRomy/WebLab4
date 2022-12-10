package com.examle.web4.controller;

import com.examle.web4.dto.ResponseDTO;
import com.examle.web4.dto.UserDTO;
import com.examle.web4.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/authorization")
@RequiredArgsConstructor
public class AuthorizationController {
    private final AuthorizationService authorizationService;
    @PostMapping
    public ResponseEntity<?> authorization(@RequestBody @Valid  UserDTO userDTO) {
        log.info("Принят запрос на авторизацию");
        ResponseDTO responseDTO = authorizationService.authorization(userDTO.getUsername(), userDTO.getPassword());
        return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(responseDTO.getStatusCode()));
    }
}
