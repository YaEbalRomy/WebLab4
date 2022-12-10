package com.examle.web4.controller;

import com.examle.web4.dto.PointDTO;
import com.examle.web4.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;
    @GetMapping
    public ResponseEntity<?> getData() {
        log.info("Запрос данных с бд");
        return new ResponseEntity<>(mainService.getData(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addResult(@RequestBody PointDTO pointDTO) {
        log.info("Запрос на добавление данных");
        return new ResponseEntity<>(mainService.addResult(pointDTO.getX(), pointDTO.getY(), pointDTO.getR()),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteFromDB() {
        log.info("Запрос на удаленные данных");
        return new ResponseEntity<>(null,mainService.deleteFromDB());
    }
}










