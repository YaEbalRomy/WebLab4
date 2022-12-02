package com.examle.web4;

import com.examle.web4.entity.Point;
import com.examle.web4.entity.Result;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class ResponseLists {
    private List<Result> resultList = new ArrayList<>();
    private List<Point> pointList = new ArrayList<>();
}
