package com.examle.web4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ResultDto {
    private double x;
    private double y;
    private double r;
    private boolean hit;
    private LocalDateTime time;
}
