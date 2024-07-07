package com.zerobase.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvise {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleException(CustomException e) {
        return new ErrorResponse(e).toResponseEntity();
    }
}
