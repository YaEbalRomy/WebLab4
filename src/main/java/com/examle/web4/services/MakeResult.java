package com.examle.web4.services;

import com.examle.web4.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MakeResult {
    @Autowired
    private CheckArea checkArea;
    public Result createResult(Result result, Double x, Double y, Double r) {
        result.setX(x);
        result.setY(y);
        result.setR(r);
        result.setResult(checkArea.checkHit(x, y, r));
        result.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));
        return result;
    }

}
