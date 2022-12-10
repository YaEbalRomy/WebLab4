package com.examle.web4.service;

import com.examle.web4.dto.ResultDTO;
import com.examle.web4.entity.Result;
import com.examle.web4.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {
    private final MakeResultService makeResult;
    private final ResultRepository resultRepository;
    public List<Result> getData() {
        return resultRepository.getResultsByOwnerUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    public ResultDTO addResult( double x, double y, double r) {
        log.info("Создание объекта...");
        Result result = makeResult.createResult(x, y, r);
        result.setOwnerUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        log.info("Добавление...");
        resultRepository.save(result);
        return new ResultDTO(result.getX(), result.getY(), result.getR(), result.getHit(), result.getTime());
    }

    @Transactional
    public HttpStatus deleteFromDB() { //todo remove http binding
        log.info("Удаление...");
        resultRepository.deleteAllByOwnerUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return HttpStatus.OK;

    }
}
