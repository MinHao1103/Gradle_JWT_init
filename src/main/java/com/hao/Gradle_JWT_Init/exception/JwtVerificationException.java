package com.hao.Gradle_JWT_Init.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtVerificationException extends RuntimeException {

    public JwtVerificationException(String message, Exception cause) {
        super(message, cause);
    }

}
