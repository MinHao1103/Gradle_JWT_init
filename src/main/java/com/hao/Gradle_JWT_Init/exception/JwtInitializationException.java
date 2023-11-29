package com.hao.Gradle_JWT_Init.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtInitializationException extends RuntimeException {

    public JwtInitializationException(String message, Exception cause) {
        super(message, cause);
    }

}
