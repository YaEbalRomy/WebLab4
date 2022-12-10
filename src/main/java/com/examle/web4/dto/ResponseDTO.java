package com.examle.web4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ResponseDTO {

    public ResponseDTO (int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseDTO (int statusCode, String accessToken, String refreshToken) {
        this.statusCode = statusCode;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    private int statusCode;
    private String message;
    private String accessToken;
    private String refreshToken;

}
