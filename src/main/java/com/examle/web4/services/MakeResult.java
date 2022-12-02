package com.examle.web4.services;

import com.examle.web4.entity.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class MakeResult {
    private final CheckArea checkArea;
    public Result createResult(Double x, Double y, Double r) {
        Result result = new Result();
        result.setX(x);
        result.setY(y);
        result.setR(r);
        result.setResult(checkArea.checkHit(x, y, r));
        result.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));
        return result;
    }
}
