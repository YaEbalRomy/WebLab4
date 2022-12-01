package com.examle.web4.services;

public class CheckArea {
    private CheckArea() {}
    public static Boolean checkHit(Double x, Double y, Double r) {
        if ((x <= 0) && (x >= -r) && (y >= -r) && (y <= 0)) {
            return true;
        }
        if ((x <= 0) && (y >= 0) && (y <= x + r)) {
            return true;
        }
        if ((x >= 0) && (y <= 0) && (x * x + y * y <= (r) * (r))) {
            return true;
        }
        return false;
    }
}
