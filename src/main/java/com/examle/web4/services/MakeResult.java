package com.examle.web4.services;

import com.examle.web4.entity.Result;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MakeResult {
    private final Result result = new Result();
    public Result createResult(Double x, Double y, Double r) {
        result.setX(x);
        result.setY(y);
        result.setR(r);
        result.setResult(CheckArea.checkHit(x,y,r));
        result.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));
        return result;
    }
}
