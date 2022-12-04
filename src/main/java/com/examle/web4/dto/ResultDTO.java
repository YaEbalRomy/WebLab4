package com.examle.web4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
    private double x;
    private double y;
    private double r;
    private boolean hit;
    private String time;
}
