package com.examle.web4.jwt;

import javax.naming.AuthenticationException;

public class JwtAuthException extends AuthenticationException {
    public JwtAuthException(String msg) {
        super(msg);
    }
}
