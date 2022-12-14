package com.examle.web4.service;

import com.examle.web4.dto.ResDto;
import com.examle.web4.dto.ResultDto;
import com.examle.web4.entity.Result;
import com.examle.web4.entity.User;
import com.examle.web4.repository.ResultRepository;
import com.examle.web4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MainService {
    private final MakeResultService makeResult;
    private final UserRepository userRepository;

    private final ResultRepository resultRepository;
    public ResDto getData() {
        Optional<User> user = userRepository.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return user.map(value -> new ResDto(HttpStatus.OK.value(), resultRepository.getByUserId(value.getId()).get())).orElseGet(() -> new ResDto(HttpStatus.BAD_REQUEST.value()));
    }
    public ResDto addResult(double x, double y, double r) {
        Result result = makeResult.createResult(x, y, r);
        Optional<User> user = userRepository.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user.isPresent()) {
            result.setUser(user.get());
            resultRepository.save(result);
            return new ResDto(HttpStatus.OK.value(), new ResultDto(result.getX(), result.getY(), result.getR(), result.getHit(), result.getTime()));
        } else {
            return new ResDto(HttpStatus.BAD_REQUEST.value());
        }
    }
    @Transactional
    public ResDto deleteFromDB() {
        Optional<User> user = userRepository.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user.isPresent()) {
            resultRepository.deleteAllByUserId(user.get().getId());
            return new ResDto(HttpStatus.OK.value());
        } else {
            return new ResDto(HttpStatus.BAD_REQUEST.value());
        }
    }
}
