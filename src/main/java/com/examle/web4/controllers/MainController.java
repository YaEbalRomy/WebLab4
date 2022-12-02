package com.examle.web4.controllers;

import com.examle.web4.dto.Point;
import com.examle.web4.dto.ResultDTO;
import com.examle.web4.entity.Result;
import com.examle.web4.repositories.ResultRepository;
import com.examle.web4.services.MakeResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class MainController {
    private final ResultRepository resultRepository;
    private final MakeResult makeResult;
    @GetMapping
    public List<Result> getData() {
        return resultRepository.findAll();
    }
    @PostMapping
    public ResultDTO addResult(@RequestBody Point point) {
        Result result = makeResult.createResult(point.getX(), point.getY(), point.getR());
        resultRepository.save(result);
        return new ResultDTO(result.getX(), result.getY(), result.getR(), result.getResult(), result.getTime());
    }
    @DeleteMapping
    public HttpStatus deleteFromDB() {
        resultRepository.deleteAll();
        return HttpStatus.OK;
    }
}










