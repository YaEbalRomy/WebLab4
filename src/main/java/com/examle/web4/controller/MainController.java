package com.examle.web4.controller;

import com.examle.web4.dto.PointDTO;
import com.examle.web4.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/results")
public class MainController {
    private final MainService mainService;
    @GetMapping
    public ResponseEntity<?> getData() {
        log.info("Запрос данных с бд");
        return new ResponseEntity<>(mainService.getData(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addResult(@RequestBody @Valid PointDTO pointDTO) {
        log.info("Запрос на добавление данных");
        return new ResponseEntity<>(mainService.addResult(pointDTO.getX(), pointDTO.getY(), pointDTO.getR()),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteFromDB() {
        log.info("Запрос на удаленные данных");
        return new ResponseEntity<>(mainService.deleteFromDB(), HttpStatus.OK);
    }
}










