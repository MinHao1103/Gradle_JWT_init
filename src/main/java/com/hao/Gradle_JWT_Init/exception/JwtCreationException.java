package com.hao.Gradle_JWT_Init.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtCreationException extends RuntimeException {

    public JwtCreationException(String message, Exception cause) {
        super(message, cause);
    }

}
