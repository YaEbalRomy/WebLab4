package com.examle.web4.controller;

import com.examle.web4.dto.ReqPointDto;
import com.examle.web4.dto.ResDto;
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
        ResDto resDto = mainService.getData();
        if (resDto.getStatus() == 200) {
            log.info("Запрос прошел успешно");
            return new ResponseEntity<>(resDto.getObject(), HttpStatus.OK);
        } else {
            log.warn("Запрос прошел не успешно");
            return new ResponseEntity<>(resDto.getObject(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<?> addResult(@RequestBody @Valid ReqPointDto reqPointDto) {
        log.info("Запрос на добавление данных");
        ResDto resDto = mainService.addResult(reqPointDto.getX(), reqPointDto.getY(), reqPointDto.getR());
        if (resDto.getStatus() == 200) {
            log.info("Данные добавлены");
            return new ResponseEntity<>(resDto.getObject(),HttpStatus.OK);
        } else {
            log.warn("Данные не добавлены");
            return new ResponseEntity<>(resDto.getObject(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteFromDB() {
        log.info("Запрос на удаленные данных");
        ResDto resDto = mainService.deleteFromDB();
        if (resDto.getStatus() == 200) {
            log.info("Данные удалены");
            return new ResponseEntity<>(resDto, HttpStatus.OK);
        } else {
            log.warn("Данные не удалены");
            return new ResponseEntity<>(resDto, HttpStatus.BAD_REQUEST);
        }
    }
}










