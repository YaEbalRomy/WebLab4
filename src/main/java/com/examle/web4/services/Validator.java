package com.examle.web4.services;

import org.springframework.stereotype.Component;

@Component
public class Validator {
    public boolean validate(double x, double y, double r) {
        if (x >= 5 || x <= -5) {
            return false;
        } else if (y >= 5 || y <= -5) {
            return false;
        } else {
            return true;
        }
    }
}
