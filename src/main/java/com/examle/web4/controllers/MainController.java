package com.examle.web4.controllers;

import com.examle.web4.entity.Result;
import com.examle.web4.repositories.ResultRepository;
import com.examle.web4.services.MakeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    ResultRepository resultRepository;

    List<Result> list = new ArrayList<>();
    MakeResult makeResult = new MakeResult();

    Result result = new Result();


    @GetMapping("api/result")
    public List<Result> getData() {
        Iterable<Result> results = resultRepository.findAll();
        results.forEach(result1 -> list.add(result1));
        return list;
    }

    @PostMapping("api/result")
    public Result createResult(@RequestParam Double x, @RequestParam Double y, @RequestParam Double r) {
        result = makeResult.createResult(x, y, r);
        resultRepository.save(result);
        return result;
    }
}