package com.examle.web4.service;

import com.examle.web4.dto.ResponseDTO;
import com.examle.web4.entity.User;
import com.examle.web4.jwt.JwtTokenProvider;
import com.examle.web4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public ResponseDTO authorization(String username, String password) {
        log.info("Происходит авторизация пользователя - " + username);
        Optional<User> user = userRepository.getByUsername(username);
        if (!user.isPresent()) {
            log.error("Такого пользователя не существует");
            return new ResponseDTO(HttpStatus.CONFLICT.value(), "Такого пользователя не существует");
        } else {
            if (passwordEncoder.matches(password,user.get().getPassword())) {
                String accessToken = jwtTokenProvider.createToken(username, 600000);
                String refreshToken = jwtTokenProvider.createToken(username, 1800000);
                user.get().setRefreshToken(refreshToken);
                userRepository.save(user.get());
                log.info("Авторизация прошла успешно");
                return new ResponseDTO(HttpStatus.OK.value(), accessToken, refreshToken);
            } else {
                log.error("Авторизация не прошла, неверный пароль");
                return new ResponseDTO(HttpStatus.BAD_REQUEST.value(), "Авторизация не прошла, неверный пароль");
            }
        }
    }
}
