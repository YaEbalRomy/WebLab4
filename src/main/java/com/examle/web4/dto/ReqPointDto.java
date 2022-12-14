package com.examle.web4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class ReqPointDto {
    @Min(-5)
    @Max(3)
    @NotNull
    private double x;
    @Min(-5)
    @Max(5)
    @NotNull
    private double y;
    @Min(1)
    @Max(5)
    @NotNull
    private double r;
}
