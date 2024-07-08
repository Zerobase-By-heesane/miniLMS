package com.zerobase.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class ErrorResponse {
    HttpStatus httpStatus;
    String message;
    int status;

    ErrorResponse(CustomException customException) {
        this.httpStatus = customException.getHttpStatus();
        this.message = customException.getErrorMessage();
        this.status = customException.getHttpStatus().value();
    }


    ResponseEntity<ErrorResponse> toResponseEntity() {
        return ResponseEntity
                .status(httpStatus)
                .body(this);
    }
}
