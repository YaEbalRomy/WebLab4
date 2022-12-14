package com.examle.web4.controller;

import com.examle.web4.dto.ResponseDTO;
import com.examle.web4.dto.ReqUserDto;
import com.examle.web4.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    @PostMapping
    public ResponseEntity<?> processRegistration(@RequestBody @Valid ReqUserDto reqUserDto) {
        log.info("Принят запрос на регистрацию");
        ResponseDTO responseDTO = registrationService.registration(reqUserDto.getUsername(), reqUserDto.getPassword());
        return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(responseDTO.getStatusCode()));
    }
}
