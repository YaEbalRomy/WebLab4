package com.examle.web4.controller;

import com.examle.web4.dto.PointDTO;
import com.examle.web4.dto.ResultDTO;
import com.examle.web4.entity.Result;
import com.examle.web4.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;
    @GetMapping
    public List<Result> getData() {
        log.info("Запрос данных с бд");
        return mainService.getData();
    }
    @PostMapping
    public ResultDTO addResult(@RequestBody PointDTO pointDTO) {
        log.info("Запрос на добавление данных");
        return mainService.addResult(pointDTO.getX(), pointDTO.getY(), pointDTO.getR());
    }
    @DeleteMapping
    public HttpStatus deleteFromDB() {
        log.info("Запрос на удаленные данных");
        return mainService.deleteFromDB();
    }
}










