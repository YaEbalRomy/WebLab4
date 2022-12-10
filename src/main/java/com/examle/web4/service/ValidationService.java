package com.examle.web4.service;

import org.springframework.stereotype.Service;
@Service
public class ValidationService {
    public double validateX(double x) {
      if (x > 3.0)  {
          return 3.0;
      } else if (x < -5.0) {
          return -5.0;
      }
      return x;
    }
    public double validateY(double y) {
        if (y > 5.0)  {
            return 5.0;
        } else if (y < -5.0) {
            return -5.0;
        }
        return y;
    }
    public double validateR(double r) {
        if (r > 5.0)  {
            return 5.0;
        } else if (r < 1.0) {
            return 1.0;
        }
        return r;
    }
}
