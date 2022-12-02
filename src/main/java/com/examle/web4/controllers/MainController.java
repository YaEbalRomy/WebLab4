package com.examle.web4.controllers;

import com.examle.web4.ResponseLists;
import com.examle.web4.ResponseResultPoint;
import com.examle.web4.entity.Point;
import com.examle.web4.entity.Result;
import com.examle.web4.repositories.PointRepository;
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
    private PointRepository pointRepository;
    @Autowired
    private MakeResult makeResult;
    @Autowired
    private ResponseLists responseLists;
    @Autowired
    private ResponseResultPoint rsp;

    private final List<Result> resultList = new ArrayList<>();
    private final List<Point> pointList = new ArrayList<>();


    @GetMapping("api/result")
    public ResponseLists getData() {

        Iterable<Result> results = resultRepository.findAll();
        results.forEach(resultList::add);
        responseLists.setResultList(resultList);

        Iterable<Point> points = pointRepository.findAll();
        points.forEach(pointList::add);
        responseLists.setPointList(pointList);

        return responseLists;
    }

    @PostMapping("api/result")
    public ResponseResultPoint addResult(@RequestParam Double x, @RequestParam Double y, @RequestParam Double r) throws CloneNotSupportedException {
        rsp = makeResult.createObjectForResponse(rsp, x, y, r);
        resultRepository.save((Result) rsp.getResult().clone());
        pointRepository.save((Point) rsp.getPoint().clone());
        return rsp;
    }

    @DeleteMapping("api/result")
    public HttpStatus deleteFromDB() {
        resultRepository.deleteAll();
        pointRepository.deleteAll();

        resultList.clear();
        pointList.clear();

        responseLists.getPointList().clear();
        responseLists.getPointList().clear();

        return HttpStatus.OK;
    }
}