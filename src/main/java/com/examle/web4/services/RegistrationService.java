package com.examle.web4.services;

import com.examle.web4.entityes.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final DbService dbService;
    private final PasswordEncoder passwordEncoder;
    public ResponseEntity<?> registration(String username, String password) {
        log.info("Происходит регистрация пользователя - " + username);
        User user = dbService.findByUsername(username);
        if (user == null) {
            user = new User(username, passwordEncoder.encode(password));
            dbService.saveUser(user);
            log.info("Пользователь зарегистрирован");
            return ResponseEntity.status(HttpStatus.OK).body("Пользователь зарегистрирован");
        } else {
            log.error("Такой пользователь уже существует");
            return ResponseEntity.status(HttpStatus.OK).body("Такой пользователь уже существует");
        }
    }

}
