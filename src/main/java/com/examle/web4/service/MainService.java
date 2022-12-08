package com.examle.web4.service;

import com.examle.web4.dto.ResultDTO;
import com.examle.web4.entity.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {
    private final DbService dbService;
    private final MakeResultService makeResult;
    public List<Result> getData() {
        return dbService.getData(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    public ResultDTO addResult( double x, double y, double r) {
        log.info("Создание объекта...");
        Result result = makeResult.createResult(x, y, r);
        result.setOwnerUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        log.info("Добавление...");
        dbService.saveResult(result);
        return new ResultDTO(result.getX(), result.getY(), result.getR(), result.getHit(), result.getTime());
    }
    public HttpStatus deleteFromDB() {
        log.info("Удаление...");
        return dbService.deleteData(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
