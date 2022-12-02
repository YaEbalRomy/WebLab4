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
    private Double x;
    private Double y;
    private Double r;
    private Boolean result;
    private String time;
}
