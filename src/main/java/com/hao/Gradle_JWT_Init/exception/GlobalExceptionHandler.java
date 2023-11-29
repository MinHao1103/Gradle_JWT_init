package com.hao.Gradle_JWT_Init.exception;

import com.hao.Gradle_JWT_Init.utils.httpResult.CommonHttpResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.hao.Gradle_JWT_Init.define.ErrorId.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<CommonHttpResult> handleException(Exception ex, int errorCode) {
        CommonHttpResult result = new CommonHttpResult(errorCode, ex.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
    }

    @ExceptionHandler(JwtCreationException.class)
    public ResponseEntity<CommonHttpResult> handleJwtCreationException(JwtCreationException ex) {
        return handleException(ex, JwtCreation_Exception);
    }

    @ExceptionHandler(JwtInitializationException.class)
    public ResponseEntity<CommonHttpResult> handleJwtInitializationException(JwtInitializationException ex) {
        return handleException(ex, JwtInitialization_Exception);
    }

    @ExceptionHandler(JwtVerificationException.class)
    public ResponseEntity<CommonHttpResult> handleJwtVerificationException(JwtVerificationException ex) {
        return handleException(ex, JwtVerification_Exception);
    }

}
