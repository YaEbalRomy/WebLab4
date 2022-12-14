package com.examle.web4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResDto {
    public ResDto(int status) {
        this.status = status;
    }
    private int status;
    private Object object;
}
