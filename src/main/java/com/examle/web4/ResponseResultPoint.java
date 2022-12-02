package com.examle.web4;

import com.examle.web4.entity.Point;
import com.examle.web4.entity.Result;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ResponseResultPoint {
    private Result result = new Result();
    private Point point = new Point();
}
