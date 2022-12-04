package com.examle.web4.services;

import org.springframework.stereotype.Component;
@Component
public class CheckArea {
    public boolean checkHit(Double x, Double y, Double r) {

        if ((x >= 0) && (x <= r) && (y <= r) && (y >= 0)) {
            return true;
        } else if ((x <= 0) && (y <= 0) && (-y <= x + r)) {
            return true;
        } else if ((x >= 0) && (y <= 0) && (x * x + y * y <= (r/2) * (r/2))) {
            return true;
        }
        return false;
    }
}
