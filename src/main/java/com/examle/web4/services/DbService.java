package com.examle.web4.services;

import com.examle.web4.entityes.Result;
import com.examle.web4.entityes.User;
import com.examle.web4.repositories.ResultRepository;
import com.examle.web4.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DbService {
    private final UserRepository userRepo;
    private final ResultRepository resultRepository;
    public List<Result> getData(String ownerUsername) {
        return resultRepository.getResultsByOwnerUsername(ownerUsername);
    }

    @Transactional
    public HttpStatus deleteData(String ownerUsername) {
        resultRepository.deleteAllByOwnerUsername(ownerUsername);
        return HttpStatus.OK;
    }
    public void saveResult(Result result) {
        resultRepository.save(result);
    }
    public void saveUser(User user) {
        userRepo.save(user);
    }
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

}
