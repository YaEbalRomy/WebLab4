package com.examle.web4.service;

import com.examle.web4.entity.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;

@Service
@SessionScope
@RequiredArgsConstructor
public class MakeResultService {
    private final CheckAreaService checkArea;
    private final ValidationService validator;
    public Result createResult(Double x, Double y, Double r) {
        Result result = new Result();
        result.setX(validator.validateX(x));
        result.setY(validator.validateY(y));
        result.setR(r);
        result.setHit(checkArea.checkHit(x, y, r));
        result.setTime(LocalDateTime.now());
        return result;
    }
}
