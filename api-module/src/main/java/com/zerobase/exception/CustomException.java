package com.zerobase.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    public CustomException(CustomErrorCode customErrorCode) {
        super(customErrorCode.getMessage());
        this.httpStatus = customErrorCode.getHttpStatus();
        this.errorCode = customErrorCode.getErrorCode();
        this.errorMessage = customErrorCode.getMessage();
    }
}
