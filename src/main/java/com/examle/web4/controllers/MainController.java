package com.examle.web4.controllers;

import com.examle.web4.entity.Result;
import com.examle.web4.repositories.ResultRepository;
import com.examle.web4.services.MakeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private MakeResult makeResult;
    private final List<Result> resultList = new ArrayList<>();
    private Result result = new Result();
    @GetMapping("api/result")
    public List<Result> getData() {
        Iterable<Result> results = resultRepository.findAll();
        results.forEach(resultList::add);
        return resultList;
    }

    @PostMapping("api/result")
    public Result addResult(@RequestBody Double x, @RequestBody Double y, @RequestBody Double r) throws CloneNotSupportedException {
        result = makeResult.createResult(result, x, y, r);
        resultRepository.save((Result) result.clone());
        return result;
    }

    @DeleteMapping("api/result")
    public HttpStatus deleteFromDB() {
        resultRepository.deleteAll();
        resultList.clear();
        return HttpStatus.OK;
    }
}