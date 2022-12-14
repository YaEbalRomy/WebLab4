package com.examle.web4.dto;

import com.examle.web4.entity.Result;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
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
