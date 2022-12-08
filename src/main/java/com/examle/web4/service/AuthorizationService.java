package com.examle.web4.service;

import com.examle.web4.dto.ResponseDTO;
import com.examle.web4.jwt.JwtTokenProvider;
import com.examle.web4.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final DbService dbService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    public ResponseEntity<?> authorization(String username, String password) {
        log.info("Происходит авторизация пользователя - " + username);
        User user = dbService.findByUsername(username);
        String token = jwtTokenProvider.createToken(username);
        if (user == null) {
            log.error("Такого пользователя не существует");
            return new ResponseEntity<>(new ResponseDTO(HttpStatus.CONFLICT.value(),"Такого пользователя не существует"), HttpStatus.CONFLICT);
        } else {
            if (passwordEncoder.matches(password,user.getPassword())) {
                log.info("Авторизация прошла успешно");
                return new ResponseEntity<>(new ResponseDTO(HttpStatus.OK.value(),token),HttpStatus.OK);
            } else {
                log.error("Авторизация не прошла, неверный пароль");
                return new ResponseEntity<>(new ResponseDTO(HttpStatus.BAD_REQUEST.value(),"Авторизация не прошла, неверный пароль"),HttpStatus.BAD_REQUEST);
            }
        }
    }
}
