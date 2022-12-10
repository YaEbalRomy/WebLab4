package com.examle.web4.service;

import com.examle.web4.entity.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class MakeResultService {
    private final CheckAreaService checkArea;
    private final ValidationService validator;
    public Result createResult(Double x, Double y, Double r) {

        return Result.builder()
                .x(validator.validateX(x))
                .y(validator.validateY(y))
                .r(validator.validateR(r))
                .hit(checkArea.checkHit(x, y, r))
                .time(LocalDateTime.now())
                .build();
    }
}
